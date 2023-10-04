package com.martmists.koala

import com.martmists.koala.index.CollectionIndex
import com.martmists.koala.index.Index
import com.martmists.koala.index.RangeIndex
import com.martmists.koala.series.CollectionSeries
import com.martmists.koala.series.Series
import com.martmists.koala.series.ops.plus
import kotlin.reflect.KType
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.withNullability
import kotlin.reflect.typeOf

class DataFrame<I : Any>(
    index: Index<I>
) {
    var columns: Index<String> = CollectionIndex()
        set(value) {
            field = value
        }
    var index: Index<I> = index
        set(value) {
            field = value
        }

    private val series = mutableListOf<Series<*, I>>()

    operator fun get(column: String): Series<*, I> {
        val idx = columns.indexOf(column)
        return series[idx]
    }

    operator fun get(mask: Series<Boolean, I>, column: String): Series<*, I> {
        val idx = columns.indexOf(column)
        return series[idx][mask]
    }

    @PublishedApi
    internal fun get(column: String, type: KType): Series<*, I> {
        val item = get(column)
        if (item.dtype == type ||
            item.dtype == type.withNullability(false) ||
            item.dtype.isSubtypeOf(type) ||
            item.dtype.isSubtypeOf(type.withNullability(false))) {

            return item
        }
        throw IllegalArgumentException("Column $column is not of type $type")
    }

    @PublishedApi
    internal fun get(mask: Series<Boolean, I>, column: String, type: KType): Series<*, I> {
        val item = get(column)
        if (item.dtype == type ||
            item.dtype == type.withNullability(false) ||
            item.dtype.isSubtypeOf(type) ||
            item.dtype.isSubtypeOf(type.withNullability(false))) {

            return item[mask]
        }
        throw IllegalArgumentException("Column $column is not of type $type")
    }

    @Suppress("UNCHECKED_CAST")
    @JvmName("getTyped")
    inline fun <reified T> get(column: String): Series<T, I> {
        return get(column, typeOf<T>()) as Series<T, I>
    }

    @Suppress("UNCHECKED_CAST")
    @JvmName("getMaskTyped")
    inline fun <reified T> get(mask: Series<Boolean, I>, column: String): Series<T, I> {
        return get(mask, column, typeOf<T>()) as Series<T, I>
    }

    inline operator fun <reified X> set(column: String, series: Series<X, I>) = set(column, series, ::Array)
    inline operator fun <reified T> set(column: String, value: T) = set(column, CollectionSeries(Array(index.size) { value }, index, typeOf<T>(), ::Array))

    inline operator fun <reified X> set(column: String, series: Series<X, I>, mask: Series<Boolean, I>) = set(
        mask,
        column,
        series,
        ::Array
    )

    @Suppress("UNCHECKED_CAST")
    @PublishedApi
    internal fun <T> set(
        mask: Series<Boolean, I>,
        column: String,
        value: Series<T, I>,
        gArray: (Int, (Int) -> T?) -> Array<T?>
    ) {
        val idx = columns.indexOf(column)

        if (idx == -1) {
            set(column, value[mask], gArray)
        } else {
            if (series[idx].dtype != value.dtype || series[idx].dtype != value.dtype.withNullability(true)) {
                throw IllegalArgumentException("Column $column is not of type ${value.dtype}")
            }
            (series[idx] as Series<T, I>)[index[mask]] = value
        }
    }

    internal fun setColumnDirect(column: String, series: Series<*, I>) {
        if (index == RangeIndex()) {
            index = series.index
        } else {
            require(index === series.index) { "Series must have the same index as the dataframe" }
        }

        val seriesIdx = columns.indexOf(column)

        if (seriesIdx == -1) {
            columns += column
            this.series.add(series)
        } else {
            this.series[seriesIdx] = series
        }
    }

    @PublishedApi
    internal fun <X> set(column: String, series: Series<X, I>, gArray: (Int, (Int) -> X?) -> Array<X?>) {
        if (index == RangeIndex()) {
            index = series.index
        }


        val filteredSeries = when {
            index == series.index -> {
                series
            }
            index.all { it in series.index } -> {
                series[index]
            }
            else -> {
                when (series.dtype) {
                    else -> {
                        val values = gArray(index.size) {
                            val idx = index[it]
                            if (idx in series.index) {
                                series[idx]
                            } else {
                                null
                            }
                        }
                        CollectionSeries(values, index, series.dtype.withNullability(true), gArray)
                    }
                }
            }
        }

        setColumnDirect(column, filteredSeries)
    }

    override fun toString(): String {
        // TODO: Shorten on large dataframes
        val lines = mutableListOf("")
        var longest = 0
        for (idx in index) {
            val s = idx.toString()
            lines.add(s)
            longest = maxOf(longest, s.length)
        }

        for ((i, line) in lines.withIndex()) {
            lines[i] = line.padEnd(longest)
        }

        for (column in columns) {
            val newLines = mutableListOf(column)
            var newLongest = column.length
            val series = this[column]
            for (v in series.values) {
                val s = v.toString()
                newLines.add(s)
                newLongest = maxOf(newLongest, s.length)
            }

            for ((i, line) in newLines.withIndex()) {
                lines[i] += "  " + line.padStart(newLongest)
            }
        }

        return lines.joinToString("\n")
    }

    companion object {
        operator fun invoke() = DataFrame(RangeIndex())

        @Suppress("UNCHECKED_CAST")
        operator fun invoke(items: Map<String, Array<*>>) = DataFrame(items as Map<String, Array<Any?>>)

        @JvmName("invokeTyped")
        inline operator fun <reified T> invoke(items: Map<String, Array<T>>) = DataFrame().apply {
            val length = items.values.first().size
            require(items.values.all { it.size == length }) { "All columns must be the same length" }

            items.forEach { (k, v) ->
                set(k, CollectionSeries(v, RangeIndex(0..<length), typeOf<T>(), ::Array))
            }
        }
    }
}

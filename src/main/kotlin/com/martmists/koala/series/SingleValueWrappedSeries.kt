package com.martmists.koala.series

import com.martmists.koala.index.Index
import com.martmists.koala.index.RangeIndex
import kotlin.reflect.KType
import kotlin.reflect.typeOf

class SingleValueWrappedSeries<T, I: Any>(
    @PublishedApi
    internal val value: T,
    override val index: Index<I>,
    override val dtype: KType,
    private val gArray: (Int, (Int) -> T) -> Array<T>,
): Series<T, I>() {
    @PublishedApi
    internal var isSeries = false
    private lateinit var asSeries: Series<T, I>
    override val values: Array<T>
        get() {
            return if (isSeries) {
                asSeries.values
            } else {
                gArray(index.size) { value }
            }
        }

    override fun get(index: I) = if (isSeries) asSeries[index] else value
    override fun get(indices: Index<I>) = if (isSeries) asSeries[indices] else SingleValueWrappedSeries(value, indices, dtype, gArray)

    private fun createSeries() {
        isSeries = true
        asSeries = CollectionSeries(gArray(index.size) { value }, index, dtype, gArray)
    }

    override fun set(index: I, value: T) {
        if (!isSeries) {
            createSeries()
        }
        asSeries[index] = value
    }

    override fun set(indices: Index<I>, value: Series<T, I>) {
        if (!isSeries) {
            createSeries()
        }
        asSeries[indices] = value
    }

    override fun iterator() = if (isSeries) {
        asSeries.iterator()
    } else {
        iterator {
            repeat(size) {
                yield(value)
            }
        }
    }

    companion object {
        inline operator fun <reified T, I: Any> invoke(value: T, index: Index<I>) =
            SingleValueWrappedSeries(value, index, typeOf<T>(), ::Array)
        inline operator fun <reified T> invoke(value: T) = SingleValueWrappedSeries(value, RangeIndex())
    }
}

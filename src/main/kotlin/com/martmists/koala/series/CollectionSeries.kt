package com.martmists.koala.series

import com.martmists.koala.index.Index
import com.martmists.koala.index.RangeIndex
import kotlin.reflect.KType
import kotlin.reflect.typeOf

class CollectionSeries<T, I : Any> (
    private val items: Array<T>,
    override val index: Index<I>,
    override val dtype: KType,
    private val gArray: (Int, (Int) -> T) -> Array<T>
): Series<T, I>() {
    init {
        require(items.size == index.size) { "Items and index must be the same size, got ${items.size} elements and ${index.size} indices" }
    }

    override val values = items

    override fun get(index: I): T {
        val idx = this.index.indexOf(index)
        return items[idx]
    }

    override fun get(indices: Index<I>): Series<T, I> {
        val newItems = gArray(indices.size) { get(indices[it]) }
        return CollectionSeries(newItems, indices, dtype, gArray)
    }

    override fun set(indices: Index<I>, value: Series<T, I>) {
        for (idx in indices) {
            set(idx, value[idx])
        }
    }

    override fun set(index: I, value: T) {
        val idx = this.index.indexOf(index)
        items[idx] = value
    }

    override fun iterator() = items.iterator()

    override fun toString(): String {
        val lines = mutableListOf<String>()
        var longest = 0
        for (idx in index) {
            val s = idx.toString()
            lines.add(s)
            longest = maxOf(longest, s.length)
        }

        for ((i, line) in lines.withIndex()) {
            lines[i] = line.padEnd(longest)
        }

        val newLines = mutableListOf<String>()
        longest = 0
        for (v in items) {
            val s = v.toString()
            newLines.add(s)
            longest = maxOf(longest, s.length)
        }

        for ((i, line) in newLines.withIndex()) {
            lines[i] += "  " + line.padStart(longest)
        }

        lines.add("dtype: $dtype")

        return lines.joinToString("\n")
    }

    companion object {
        inline operator fun <reified T, I : Any> invoke(items: Array<T>, index: Index<I>) =
            CollectionSeries(items, index, typeOf<T>(), ::Array)
        inline operator fun <reified T> invoke(items: Array<T>) = CollectionSeries(items, RangeIndex(items.indices))
    }
}

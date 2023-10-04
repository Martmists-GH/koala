package com.martmists.koala.series

import com.martmists.koala.index.Index
import com.martmists.koala.index.RangeIndex
import kotlin.reflect.KType
import kotlin.reflect.typeOf

class IntSeries<I : Any> (
    private val items: IntArray,
    override val index: Index<I>,
): Series<Int, I>() {
    override val dtype = typeOf<Int>()

    init {
        require(items.size == index.size) { "Items and index must be the same size, got ${items.size} elements and ${index.size} indices" }
    }

    override val values
        get() = items.toTypedArray()
    override fun get(index: I): Int {
        val idx = this.index.indexOf(index)
        return items[idx]
    }

    override fun get(indices: Index<I>): Series<Int, I> {
        val newItems = IntArray(indices.size) { get(indices[it]) }
        return IntSeries(newItems, indices)
    }

    override fun set(indices: Index<I>, value: Series<Int, I>) {
        for (idx in indices) {
            set(idx, value[idx])
        }
    }

    override fun set(index: I, value: Int) {
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
        operator fun <I : Any> invoke(items: Array<Int>, index: Index<I>) = IntSeries(items.toIntArray(), index)
        operator fun invoke(items: Array<Int>) = IntSeries(items, RangeIndex(items.indices))
        operator fun invoke(items: IntArray) = IntSeries(items, RangeIndex(items.indices))
    }
}

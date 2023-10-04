package com.martmists.koala.series

import com.martmists.koala.index.Index
import kotlin.reflect.KType

abstract class Series<T, I : Any> : Iterable<T> {
    abstract val index: Index<I>
    val size: Int
        get() = index.size
    abstract val dtype: KType

    // NOTE: `values` *may* be read-only. If you want to modify the values, use `set` instead.
    abstract val values: Array<T>

    abstract operator fun get(index: I): T
    abstract operator fun get(indices: Index<I>): Series<T, I>
    operator fun get(mask: Series<Boolean, I>): Series<T, I> = this[index[mask]]

    abstract operator fun set(index: I, value: T)
    abstract operator fun set(indices: Index<I>, value: Series<T, I>)
    operator fun set(mask: Series<Boolean, I>, value: Series<T, I>) {
        this[index[mask]] = value
    }

    override fun iterator() = values.iterator()

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
        for (v in values) {
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
}

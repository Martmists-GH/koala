package com.martmists.koala.index

import com.martmists.koala.series.Series
import kotlin.reflect.typeOf

class RangeIndex(
    private val range: IntProgression,
): Index<Int> {
    private val first = range.first
    private val step = range.step

    override val size = 1 + (range.last - range.first) / range.step
    override val dtype = typeOf<Int>()

    override fun get(index: Int): Int {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index $index out of bounds for index of size $size")
        }
        return first + index * step
    }

    override fun get(mask: Series<Boolean, Int>): Index<Int> {
        val newIndex = mask.values.zip(mask.index).mapNotNull {
            (mask, idx) -> if (mask) {
                if (idx in this) {
                    idx
                } else {
                    throw IllegalArgumentException("Index $idx not in index")
                }
            } else null
        }
        return CollectionIndex(newIndex.toTypedArray())
    }

    override fun indexOf(item: Int): Int {
        val offset = item - first
        return if (offset % step != 0) {
            -1
        } else {
            val idx = offset / step
            if (idx < 0 || idx >= size) {
                -1
            } else {
                idx
            }
        }
    }

    override fun iterator() = range.iterator()

    override fun toString() = "RangeIndex(start=${range.first}, stop=${range.last}, step=${range.step}, dtype=$dtype)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RangeIndex) return false

        if (range != other.range) return false

        return true
    }

    companion object {
        operator fun invoke() = RangeIndex(IntRange.EMPTY)
    }
}

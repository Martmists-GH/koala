package com.martmists.koala.index

import com.martmists.koala.series.Series
import kotlin.reflect.KType
import kotlin.reflect.typeOf

class CollectionIndex<I : Any>(
    private val items: Array<I>,
    override val dtype: KType,
    private val gToTypedArray: Collection<I>.() -> Array<I>,
): Index<I> {
    override val size = items.size
    private val lookup = hashMapOf<Int, Int>().apply {
        items.forEachIndexed { idx, item ->
            this[item.hashCode()] = idx
        }
    }

    override fun get(index: Int) = items[index]
    override fun get(mask: Series<Boolean, I>): Index<I> {
        val newIndex = mask.values.zip(mask.index).mapNotNull {
            (mask, idx) -> if (mask) {
                if (idx in this) {
                    idx
                } else {
                    throw IllegalArgumentException("Index $idx not in index")
                }
            } else null
        }
        return CollectionIndex(newIndex.gToTypedArray(), dtype, gToTypedArray)
    }
    override fun indexOf(item: I) = lookup[item.hashCode()] ?: -1

    override fun iterator() = items.iterator()

    override fun toString() = "Index(${items.contentToString()}, dtype=$dtype)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CollectionIndex<*>) return false

        if (!items.contentEquals(other.items)) return false

        return true
    }

    companion object {
        inline operator fun <reified T : Any> invoke() = CollectionIndex<T>(emptyArray())
        inline operator fun <reified T : Any> invoke(items: Array<T>) =
            CollectionIndex(items, typeOf<T>(), Collection<T>::toTypedArray)
    }
}

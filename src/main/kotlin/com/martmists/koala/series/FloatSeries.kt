package com.martmists.koala.series

import com.martmists.koala.index.Index
import com.martmists.koala.index.RangeIndex
import kotlin.reflect.KType
import kotlin.reflect.typeOf

class FloatSeries<I : Any> (
    private val items: FloatArray,
    override val index: Index<I>,
): Series<Float, I>() {
    override val dtype = typeOf<Float>()

    init {
        require(items.size == index.size) { "Items and index must be the same size, got ${items.size} elements and ${index.size} indices" }
    }

    override val values
        get() = items.toTypedArray()
    override fun get(index: I): Float {
        val idx = this.index.indexOf(index)
        return items[idx]
    }

    override fun get(indices: Index<I>): Series<Float, I> {
        val newItems = FloatArray(indices.size) { get(indices[it]) }
        return FloatSeries(newItems, indices)
    }

    override fun set(indices: Index<I>, value: Series<Float, I>) {
        for (idx in indices) {
            set(idx, value[idx])
        }
    }

    override fun set(index: I, value: Float) {
        val idx = this.index.indexOf(index)
        items[idx] = value
    }

    override fun iterator() = items.iterator()

    companion object {
        operator fun <I : Any> invoke(items: Array<Float>, index: Index<I>) = FloatSeries(items.toFloatArray(), index)
        operator fun invoke(items: Array<Float>) = FloatSeries(items, RangeIndex(items.indices))
        operator fun invoke(items: FloatArray) = FloatSeries(items, RangeIndex(items.indices))
    }
}

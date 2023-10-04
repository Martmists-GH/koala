package com.martmists.koala.series

import com.martmists.koala.index.Index
import com.martmists.koala.index.RangeIndex
import kotlin.reflect.KType
import kotlin.reflect.typeOf

class DoubleSeries<I : Any> (
    private val items: DoubleArray,
    override val index: Index<I>,
): Series<Double, I>() {
    override val dtype = typeOf<Double>()

    init {
        require(items.size == index.size) { "Items and index must be the same size, got ${items.size} elements and ${index.size} indices" }
    }

    override val values
        get() = items.toTypedArray()
    override fun get(index: I): Double {
        val idx = this.index.indexOf(index)
        return items[idx]
    }

    override fun get(indices: Index<I>): Series<Double, I> {
        val newItems = DoubleArray(indices.size) { get(indices[it]) }
        return DoubleSeries(newItems, indices)
    }

    override fun set(indices: Index<I>, value: Series<Double, I>) {
        for (idx in indices) {
            set(idx, value[idx])
        }
    }

    override fun set(index: I, value: Double) {
        val idx = this.index.indexOf(index)
        items[idx] = value
    }

    override fun iterator() = items.iterator()

    companion object {
        operator fun <I : Any> invoke(items: Array<Double>, index: Index<I>) = DoubleSeries(items.toDoubleArray(), index)
        operator fun invoke(items: Array<Double>) = DoubleSeries(items, RangeIndex(items.indices))
        operator fun invoke(items: DoubleArray) = DoubleSeries(items, RangeIndex(items.indices))
    }
}

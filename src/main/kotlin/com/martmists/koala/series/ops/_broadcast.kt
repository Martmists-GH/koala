package com.martmists.koala.series.ops

import com.martmists.koala.index.CollectionIndex
import com.martmists.koala.index.Index
import com.martmists.koala.series.CollectionSeries
import com.martmists.koala.series.Series
import kotlin.reflect.typeOf


internal inline operator fun <reified I : Any> Index<I>.plus(other: I): Index<I> {
    val items = Array(size + 1) { i ->
        if (i == size) {
            other
        } else {
            this[i]
        }
    }
    return CollectionIndex(items, dtype, Collection<I>::toTypedArray)
}

@PublishedApi
internal inline fun <reified I : Any> align(left: Index<I>, right: Index<I>): Index<I> {
    if (left == right) {
        return left
    }

    val begin = left
    val end = right.filter { it !in left }
    return CollectionIndex(Array(begin.size + end.size) {
        if (it < begin.size) {
            begin[it]
        } else {
            end[it - begin.size]
        }
    }, typeOf<I>(), Collection<I>::toTypedArray)
}

@PublishedApi
internal inline fun <reified L, reified R, reified I : Any> align(left: Series<L, I>, right: Series<R, I>): Pair<Series<L?, I>, Series<R?, I>> {
    val index = align(left.index, right.index)

    val leftSize = left.index.size
    val leftReindexed = Array(index.size) {
        val idx = index[it]
        if (it < leftSize) {
            left[idx]
        } else {
            null
        }
    }
    val rightIdx = right.index
    val rightReindexed = Array(index.size) {
        val idx = index[it]
        if (idx in rightIdx) {
            right[idx]
        } else {
            null
        }
    }

    if (leftReindexed.any { it == null } || rightReindexed.any { it == null }) {
        return Pair(
            CollectionSeries(leftReindexed, index, typeOf<L>(), ::Array),
            CollectionSeries(rightReindexed, index, typeOf<R>(), ::Array)
        )
    }

    return Pair(
        CollectionSeries(leftReindexed, index, typeOf<L?>(), ::Array),
        CollectionSeries(rightReindexed, index, typeOf<R?>(), ::Array)
    )
}

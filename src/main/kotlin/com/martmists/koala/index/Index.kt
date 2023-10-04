package com.martmists.koala.index

import com.martmists.koala.series.Series
import kotlin.experimental.ExperimentalTypeInference
import kotlin.reflect.KType

interface Index<I : Any> : Iterable<I> {
    val size: Int
    val dtype: KType

    operator fun get(index: Int): I
    operator fun get(mask: Series<Boolean, I>): Index<I>
    fun indexOf(item: I): Int
    operator fun contains(item: I) = indexOf(item) != -1
}

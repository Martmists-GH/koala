@file:OptIn(ExperimentalTypeInference::class)

package com.martmists.koala.series.ops

import com.martmists.koala.series.*
import kotlin.experimental.ExperimentalTypeInference
import kotlin.reflect.full.withNullability
import kotlin.reflect.typeOf


@OverloadResolutionByLambdaReturnType
@JvmName("zipMapDouble")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, transform: (L, R)  -> Double): Series<Double, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    val newValues = DoubleArray(newIndex.size) {
        val leftValue = leftValues[it] ?: return@DoubleArray Double.NaN
        val rightValue = rightValues[it] ?: return@DoubleArray Double.NaN
        transform(leftValue, rightValue)
    }

    return DoubleSeries(newValues, newIndex)
}

@JvmName("zipMapDoubleNull")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, transform: (L, R)  -> Double?): Series<Double, I> = zipMap(other) { l, r -> transform(l, r) ?: Double.NaN }

@JvmName("zipMapFloat")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, transform: (L, R)  -> Float): Series<Float, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    val newValues = FloatArray(newIndex.size) {
        val leftValue = leftValues[it] ?: return@FloatArray Float.NaN
        val rightValue = rightValues[it] ?: return@FloatArray Float.NaN
        transform(leftValue, rightValue)
    }

    return FloatSeries(newValues, newIndex)
}

@JvmName("zipMapFloatNull")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, fill: Float = Float.NaN, transform: (L, R)  -> Float?): Series<Float, I> = zipMap(other) { l, r -> transform(l, r) ?: fill }

@Suppress("UNCHECKED_CAST")
@JvmName("zipMapIntNull")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, transform: (L, R)  -> Int): Series<Int?, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    var hasNull = false
    val newValues = Array(newIndex.size) {
        val leftVal = leftValues[it]
        if (leftVal == null) {
            hasNull = true
            return@Array null
        }
        val rightVal = rightValues[it]
        if (rightVal == null) {
            hasNull = true
            return@Array null
        }

        transform(leftVal, rightVal)
    }

    return if (hasNull) {
        CollectionSeries(newValues, newIndex, typeOf<Int?>(), ::Array)
    } else {
        IntSeries((newValues as Array<Int>).toIntArray(), newIndex) as Series<Int?, I>
    }
}

@Suppress("UNCHECKED_CAST")
@JvmName("zipMapInt")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, fill: Int, transform: (L, R)  -> Int): Series<Int, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    val newValues = IntArray(newIndex.size) {
        val leftVal = leftValues[it] ?: return@IntArray fill
        val rightVal = rightValues[it] ?: return@IntArray fill

        transform(leftVal, rightVal)
    }

    return IntSeries(newValues, newIndex)
}

@Suppress("UNCHECKED_CAST")
@JvmName("zipMapLongNull")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, transform: (L, R)  -> Long): Series<Long?, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    var hasNull = false
    val newValues = Array(newIndex.size) {
        val leftVal = leftValues[it]
        if (leftVal == null) {
            hasNull = true
            return@Array null
        }
        val rightVal = rightValues[it]
        if (rightVal == null) {
            hasNull = true
            return@Array null
        }

        transform(leftVal, rightVal)
    }

    return if (hasNull) {
        CollectionSeries(newValues, newIndex, typeOf<Long?>(), ::Array)
    } else {
        LongSeries((newValues as Array<Long>).toLongArray(), newIndex) as Series<Long?, I>
    }
}

@Suppress("UNCHECKED_CAST")
@JvmName("zipMapLong")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, fill: Long, transform: (L, R)  -> Long): Series<Long, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    val newValues = LongArray(newIndex.size) {
        val leftVal = leftValues[it] ?: return@LongArray fill
        val rightVal = rightValues[it] ?: return@LongArray fill

        transform(leftVal, rightVal)
    }

    return LongSeries(newValues, newIndex)
}

@Suppress("UNCHECKED_CAST")
@JvmName("zipMapBooleanNull")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, fill: Boolean, transform: (L, R)  -> Boolean): Series<Boolean, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    val newValues = BooleanArray(newIndex.size) {
        val leftVal = leftValues[it] ?: return@BooleanArray fill
        val rightVal = rightValues[it] ?: return@BooleanArray fill

        transform(leftVal, rightVal)
    }

    return BooleanSeries(newValues, newIndex)
}

@Suppress("UNCHECKED_CAST")
@JvmName("zipMapBoolean")
inline fun <reified L : Any, reified R : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, transform: (L, R)  -> Boolean): Series<Boolean?, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    var hasNull = false
    val newValues = Array(newIndex.size) {
        val leftVal = leftValues[it]
        if (leftVal == null) {
            hasNull = true
            return@Array null
        }
        val rightVal = rightValues[it]
        if (rightVal == null) {
            hasNull = true
            return@Array null
        }

        transform(leftVal, rightVal)
    }

    return if (hasNull) {
        CollectionSeries(newValues, newIndex, typeOf<Boolean?>(), ::Array)
    } else {
        BooleanSeries((newValues as Array<Boolean>).toBooleanArray(), newIndex) as Series<Boolean?, I>
    }
}

@JvmName("zipMapNull")
inline fun <reified L : Any, reified R : Any, reified N : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, transform: (L, R)  -> N): Series<N?, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    var hasNull = false
    val newValues = Array(newIndex.size) {
        val leftVal = leftValues[it]
        if (leftVal == null) {
            hasNull = true
            return@Array null
        }
        val rightVal = rightValues[it]
        if (rightVal == null) {
            hasNull = true
            return@Array null
        }

        transform(leftVal, rightVal)
    }

    return CollectionSeries(newValues, newIndex, typeOf<N>().withNullability(hasNull), ::Array)
}

inline fun <reified L : Any, reified R : Any, reified N : Any, reified I : Any> Series<L, I>.zipMap(other: Series<R, I>, fill: N, transform: (L, R)  -> N): Series<N, I> {
    val (left, right) = align(this, other)
    val newIndex = left.index
    val leftValues = left.values
    val rightValues = right.values

    val newValues = Array(newIndex.size) {
        val leftVal = leftValues[it] ?: return@Array fill
        val rightVal = rightValues[it] ?: return@Array fill

        transform(leftVal, rightVal)
    }

    return CollectionSeries(newValues, newIndex, typeOf<N>(), ::Array)
}

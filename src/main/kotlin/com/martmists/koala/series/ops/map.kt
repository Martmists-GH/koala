@file:OptIn(ExperimentalTypeInference::class)

package com.martmists.koala.series.ops

import com.martmists.koala.series.*
import kotlin.experimental.ExperimentalTypeInference
import kotlin.reflect.typeOf

@OverloadResolutionByLambdaReturnType
@JvmName("mapInt")
inline fun <T, I : Any> Series<T, I>.map(transform: (T) -> Int): Series<Int, I> {
    if (this is SingleValueWrappedSeries && !this.isSeries) {
        return SingleValueWrappedSeries(transform(value), index)
    }
    val items = IntArray(size) { transform(values[it]) }
    return IntSeries(items, index)
}

@JvmName("mapLong")
inline fun <T, I : Any> Series<T, I>.map(transform: (T) -> Long): Series<Long, I> {
    if (this is SingleValueWrappedSeries && !this.isSeries) {
        return SingleValueWrappedSeries(transform(value), index)
    }
    val items = LongArray(size) { transform(values[it]) }
    return LongSeries(items, index)
}

@JvmName("mapDouble")
inline fun <T, I : Any> Series<T, I>.map(transform: (T) -> Double): Series<Double, I> {
    if (this is SingleValueWrappedSeries && !this.isSeries) {
        return SingleValueWrappedSeries(transform(value), index)
    }
    val items = DoubleArray(size) { transform(values[it]) }
    return DoubleSeries(items, index)
}

@JvmName("mapDoubleNull")
inline fun <T, I : Any> Series<T, I>.map(transform: (T) -> Double?): Series<Double, I> {
    if (this is SingleValueWrappedSeries && !this.isSeries) {
        return SingleValueWrappedSeries(transform(value) ?: Double.NaN, index)
    }
    val items = DoubleArray(size) { transform(values[it]) ?: Double.NaN }
    return DoubleSeries(items, index)
}

@JvmName("mapFloat")
inline fun <T, I : Any> Series<T, I>.map(transform: (T) -> Float): Series<Float, I> {
    if (this is SingleValueWrappedSeries && !this.isSeries) {
        return SingleValueWrappedSeries(transform(value), index)
    }
    val items = FloatArray(size) { transform(values[it]) }
    return FloatSeries(items, index)
}

@JvmName("mapFloatNull")
inline fun <T, I : Any> Series<T, I>.map(transform: (T) -> Float?): Series<Float, I> {
    if (this is SingleValueWrappedSeries && !this.isSeries) {
        return SingleValueWrappedSeries(transform(value) ?: Float.NaN, index)
    }
    val items = FloatArray(size) { transform(values[it]) ?: Float.NaN }
    return FloatSeries(items, index)
}

@JvmName("mapBoolean")
inline fun <T, I : Any> Series<T, I>.map(transform: (T) -> Boolean): Series<Boolean, I> {
    if (this is SingleValueWrappedSeries && !this.isSeries) {
        return SingleValueWrappedSeries(transform(value), index)
    }
    val items = BooleanArray(size) { transform(values[it]) }
    return BooleanSeries(items, index)
}

inline fun <T, reified N, I : Any> Series<T, I>.map(transform: (T) -> N): Series<N, I> {
    val items = Array(size) { transform(values[it]) }
    return CollectionSeries(items, index, typeOf<N>(), ::Array)
}

package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("timesInt")
inline operator fun <reified I: Any> Series<Int, I>.times(other: Series<Int, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesIntLong")
inline operator fun <reified I: Any> Series<Int, I>.times(other: Series<Long, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesIntFloat")
inline operator fun <reified I: Any> Series<Int, I>.times(other: Series<Float, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesIntDouble")
inline operator fun <reified I: Any> Series<Int, I>.times(other: Series<Double, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesLongInt")
inline operator fun <reified I: Any> Series<Long, I>.times(other: Series<Int, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesLong")
inline operator fun <reified I: Any> Series<Long, I>.times(other: Series<Long, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesLongFloat")
inline operator fun <reified I: Any> Series<Long, I>.times(other: Series<Float, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesLongDouble")
inline operator fun <reified I: Any> Series<Long, I>.times(other: Series<Double, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesFloatInt")
inline operator fun <reified I: Any> Series<Float, I>.times(other: Series<Int, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesFloatLong")
inline operator fun <reified I: Any> Series<Float, I>.times(other: Series<Long, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesFloat")
inline operator fun <reified I: Any> Series<Float, I>.times(other: Series<Float, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesFloatDouble")
inline operator fun <reified I: Any> Series<Float, I>.times(other: Series<Double, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesDoubleInt")
inline operator fun <reified I: Any> Series<Double, I>.times(other: Series<Int, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesDoubleLong")
inline operator fun <reified I: Any> Series<Double, I>.times(other: Series<Long, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesDoubleFloat")
inline operator fun <reified I: Any> Series<Double, I>.times(other: Series<Float, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesDouble")
inline operator fun <reified I: Any> Series<Double, I>.times(other: Series<Double, I>) = zipMap(other) { a, b -> a * b }
@JvmName("timesIntSingle")
inline operator fun <reified I: Any> Series<Int, I>.times(other: Int) = map { it * other }
@JvmName("timesIntLongSingle")
inline operator fun <reified I: Any> Series<Int, I>.times(other: Long) = map { it * other }
@JvmName("timesIntFloatSingle")
inline operator fun <reified I: Any> Series<Int, I>.times(other: Float) = map { it * other }
@JvmName("timesIntDoubleSingle")
inline operator fun <reified I: Any> Series<Int, I>.times(other: Double) = map { it * other }
@JvmName("timesLongIntSingle")
inline operator fun <reified I: Any> Series<Long, I>.times(other: Int) = map { it * other }
@JvmName("timesLongSingle")
inline operator fun <reified I: Any> Series<Long, I>.times(other: Long) = map { it * other }
@JvmName("timesLongFloatSingle")
inline operator fun <reified I: Any> Series<Long, I>.times(other: Float) = map { it * other }
@JvmName("timesLongDoubleSingle")
inline operator fun <reified I: Any> Series<Long, I>.times(other: Double) = map { it * other }
@JvmName("timesFloatIntSingle")
inline operator fun <reified I: Any> Series<Float, I>.times(other: Int) = map { it * other }
@JvmName("timesFloatLongSingle")
inline operator fun <reified I: Any> Series<Float, I>.times(other: Long) = map { it * other }
@JvmName("timesFloatSingle")
inline operator fun <reified I: Any> Series<Float, I>.times(other: Float) = map { it * other }
@JvmName("timesFloatDoubleSingle")
inline operator fun <reified I: Any> Series<Float, I>.times(other: Double) = map { it * other }
@JvmName("timesDoubleIntSingle")
inline operator fun <reified I: Any> Series<Double, I>.times(other: Int) = map { it * other }
@JvmName("timesDoubleLongSingle")
inline operator fun <reified I: Any> Series<Double, I>.times(other: Long) = map { it * other }
@JvmName("timesDoubleFloatSingle")
inline operator fun <reified I: Any> Series<Double, I>.times(other: Float) = map { it * other }
@JvmName("timesDoubleSingle")
inline operator fun <reified I: Any> Series<Double, I>.times(other: Double) = map { it * other }

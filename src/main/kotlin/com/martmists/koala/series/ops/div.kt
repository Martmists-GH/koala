package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("divInt")
inline operator fun <reified I: Any> Series<Int, I>.div(other: Series<Int, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divIntLong")
inline operator fun <reified I: Any> Series<Int, I>.div(other: Series<Long, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divIntFloat")
inline operator fun <reified I: Any> Series<Int, I>.div(other: Series<Float, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divIntDouble")
inline operator fun <reified I: Any> Series<Int, I>.div(other: Series<Double, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divLongInt")
inline operator fun <reified I: Any> Series<Long, I>.div(other: Series<Int, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divLong")
inline operator fun <reified I: Any> Series<Long, I>.div(other: Series<Long, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divLongFloat")
inline operator fun <reified I: Any> Series<Long, I>.div(other: Series<Float, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divLongDouble")
inline operator fun <reified I: Any> Series<Long, I>.div(other: Series<Double, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divFloatInt")
inline operator fun <reified I: Any> Series<Float, I>.div(other: Series<Int, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divFloatLong")
inline operator fun <reified I: Any> Series<Float, I>.div(other: Series<Long, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divFloat")
inline operator fun <reified I: Any> Series<Float, I>.div(other: Series<Float, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divFloatDouble")
inline operator fun <reified I: Any> Series<Float, I>.div(other: Series<Double, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divDoubleInt")
inline operator fun <reified I: Any> Series<Double, I>.div(other: Series<Int, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divDoubleLong")
inline operator fun <reified I: Any> Series<Double, I>.div(other: Series<Long, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divDoubleFloat")
inline operator fun <reified I: Any> Series<Double, I>.div(other: Series<Float, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divDouble")
inline operator fun <reified I: Any> Series<Double, I>.div(other: Series<Double, I>) = zipMap(other) { a, b -> a / b }
@JvmName("divIntSingle")
inline operator fun <reified I: Any> Series<Int, I>.div(other: Int) = map { it / other }
@JvmName("divIntLongSingle")
inline operator fun <reified I: Any> Series<Int, I>.div(other: Long) = map { it / other }
@JvmName("divIntFloatSingle")
inline operator fun <reified I: Any> Series<Int, I>.div(other: Float) = map { it / other }
@JvmName("divIntDoubleSingle")
inline operator fun <reified I: Any> Series<Int, I>.div(other: Double) = map { it / other }
@JvmName("divLongIntSingle")
inline operator fun <reified I: Any> Series<Long, I>.div(other: Int) = map { it / other }
@JvmName("divLongSingle")
inline operator fun <reified I: Any> Series<Long, I>.div(other: Long) = map { it / other }
@JvmName("divLongFloatSingle")
inline operator fun <reified I: Any> Series<Long, I>.div(other: Float) = map { it / other }
@JvmName("divLongDoubleSingle")
inline operator fun <reified I: Any> Series<Long, I>.div(other: Double) = map { it / other }
@JvmName("divFloatIntSingle")
inline operator fun <reified I: Any> Series<Float, I>.div(other: Int) = map { it / other }
@JvmName("divFloatLongSingle")
inline operator fun <reified I: Any> Series<Float, I>.div(other: Long) = map { it / other }
@JvmName("divFloatSingle")
inline operator fun <reified I: Any> Series<Float, I>.div(other: Float) = map { it / other }
@JvmName("divFloatDoubleSingle")
inline operator fun <reified I: Any> Series<Float, I>.div(other: Double) = map { it / other }
@JvmName("divDoubleIntSingle")
inline operator fun <reified I: Any> Series<Double, I>.div(other: Int) = map { it / other }
@JvmName("divDoubleLongSingle")
inline operator fun <reified I: Any> Series<Double, I>.div(other: Long) = map { it / other }
@JvmName("divDoubleFloatSingle")
inline operator fun <reified I: Any> Series<Double, I>.div(other: Float) = map { it / other }
@JvmName("divDoubleSingle")
inline operator fun <reified I: Any> Series<Double, I>.div(other: Double) = map { it / other }

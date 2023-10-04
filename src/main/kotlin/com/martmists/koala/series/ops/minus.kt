package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("minusInt")
inline operator fun <reified I: Any> Series<Int, I>.minus(other: Series<Int, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusIntLong")
inline operator fun <reified I: Any> Series<Int, I>.minus(other: Series<Long, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusIntFloat")
inline operator fun <reified I: Any> Series<Int, I>.minus(other: Series<Float, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusIntDouble")
inline operator fun <reified I: Any> Series<Int, I>.minus(other: Series<Double, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusLongInt")
inline operator fun <reified I: Any> Series<Long, I>.minus(other: Series<Int, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusLong")
inline operator fun <reified I: Any> Series<Long, I>.minus(other: Series<Long, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusLongFloat")
inline operator fun <reified I: Any> Series<Long, I>.minus(other: Series<Float, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusLongDouble")
inline operator fun <reified I: Any> Series<Long, I>.minus(other: Series<Double, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusFloatInt")
inline operator fun <reified I: Any> Series<Float, I>.minus(other: Series<Int, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusFloatLong")
inline operator fun <reified I: Any> Series<Float, I>.minus(other: Series<Long, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusFloat")
inline operator fun <reified I: Any> Series<Float, I>.minus(other: Series<Float, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusFloatDouble")
inline operator fun <reified I: Any> Series<Float, I>.minus(other: Series<Double, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusDoubleInt")
inline operator fun <reified I: Any> Series<Double, I>.minus(other: Series<Int, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusDoubleLong")
inline operator fun <reified I: Any> Series<Double, I>.minus(other: Series<Long, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusDoubleFloat")
inline operator fun <reified I: Any> Series<Double, I>.minus(other: Series<Float, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusDouble")
inline operator fun <reified I: Any> Series<Double, I>.minus(other: Series<Double, I>) = zipMap(other) { a, b -> a - b }
@JvmName("minusIntSingle")
inline operator fun <reified I: Any> Series<Int, I>.minus(other: Int) = map { it - other }
@JvmName("minusIntLongSingle")
inline operator fun <reified I: Any> Series<Int, I>.minus(other: Long) = map { it - other }
@JvmName("minusIntFloatSingle")
inline operator fun <reified I: Any> Series<Int, I>.minus(other: Float) = map { it - other }
@JvmName("minusIntDoubleSingle")
inline operator fun <reified I: Any> Series<Int, I>.minus(other: Double) = map { it - other }
@JvmName("minusLongIntSingle")
inline operator fun <reified I: Any> Series<Long, I>.minus(other: Int) = map { it - other }
@JvmName("minusLongSingle")
inline operator fun <reified I: Any> Series<Long, I>.minus(other: Long) = map { it - other }
@JvmName("minusLongFloatSingle")
inline operator fun <reified I: Any> Series<Long, I>.minus(other: Float) = map { it - other }
@JvmName("minusLongDoubleSingle")
inline operator fun <reified I: Any> Series<Long, I>.minus(other: Double) = map { it - other }
@JvmName("minusFloatIntSingle")
inline operator fun <reified I: Any> Series<Float, I>.minus(other: Int) = map { it - other }
@JvmName("minusFloatLongSingle")
inline operator fun <reified I: Any> Series<Float, I>.minus(other: Long) = map { it - other }
@JvmName("minusFloatSingle")
inline operator fun <reified I: Any> Series<Float, I>.minus(other: Float) = map { it - other }
@JvmName("minusFloatDoubleSingle")
inline operator fun <reified I: Any> Series<Float, I>.minus(other: Double) = map { it - other }
@JvmName("minusDoubleIntSingle")
inline operator fun <reified I: Any> Series<Double, I>.minus(other: Int) = map { it - other }
@JvmName("minusDoubleLongSingle")
inline operator fun <reified I: Any> Series<Double, I>.minus(other: Long) = map { it - other }
@JvmName("minusDoubleFloatSingle")
inline operator fun <reified I: Any> Series<Double, I>.minus(other: Float) = map { it - other }
@JvmName("minusDoubleSingle")
inline operator fun <reified I: Any> Series<Double, I>.minus(other: Double) = map { it - other }

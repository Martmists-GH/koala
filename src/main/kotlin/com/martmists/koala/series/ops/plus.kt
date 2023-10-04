package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("plusInt")
inline operator fun <reified I: Any> Series<Int, I>.plus(other: Series<Int, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusIntLong")
inline operator fun <reified I: Any> Series<Int, I>.plus(other: Series<Long, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusIntFloat")
inline operator fun <reified I: Any> Series<Int, I>.plus(other: Series<Float, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusIntDouble")
inline operator fun <reified I: Any> Series<Int, I>.plus(other: Series<Double, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusLongInt")
inline operator fun <reified I: Any> Series<Long, I>.plus(other: Series<Int, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusLong")
inline operator fun <reified I: Any> Series<Long, I>.plus(other: Series<Long, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusLongFloat")
inline operator fun <reified I: Any> Series<Long, I>.plus(other: Series<Float, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusLongDouble")
inline operator fun <reified I: Any> Series<Long, I>.plus(other: Series<Double, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusFloatInt")
inline operator fun <reified I: Any> Series<Float, I>.plus(other: Series<Int, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusFloatLong")
inline operator fun <reified I: Any> Series<Float, I>.plus(other: Series<Long, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusFloat")
inline operator fun <reified I: Any> Series<Float, I>.plus(other: Series<Float, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusFloatDouble")
inline operator fun <reified I: Any> Series<Float, I>.plus(other: Series<Double, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusDoubleInt")
inline operator fun <reified I: Any> Series<Double, I>.plus(other: Series<Int, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusDoubleLong")
inline operator fun <reified I: Any> Series<Double, I>.plus(other: Series<Long, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusDoubleFloat")
inline operator fun <reified I: Any> Series<Double, I>.plus(other: Series<Float, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusDouble")
inline operator fun <reified I: Any> Series<Double, I>.plus(other: Series<Double, I>) = zipMap(other) { a, b -> a + b }
@JvmName("plusIntSingle")
inline operator fun <reified I: Any> Series<Int, I>.plus(other: Int) = map { it + other }
@JvmName("plusIntLongSingle")
inline operator fun <reified I: Any> Series<Int, I>.plus(other: Long) = map { it + other }
@JvmName("plusIntFloatSingle")
inline operator fun <reified I: Any> Series<Int, I>.plus(other: Float) = map { it + other }
@JvmName("plusIntDoubleSingle")
inline operator fun <reified I: Any> Series<Int, I>.plus(other: Double) = map { it + other }
@JvmName("plusLongIntSingle")
inline operator fun <reified I: Any> Series<Long, I>.plus(other: Int) = map { it + other }
@JvmName("plusLongSingle")
inline operator fun <reified I: Any> Series<Long, I>.plus(other: Long) = map { it + other }
@JvmName("plusLongFloatSingle")
inline operator fun <reified I: Any> Series<Long, I>.plus(other: Float) = map { it + other }
@JvmName("plusLongDoubleSingle")
inline operator fun <reified I: Any> Series<Long, I>.plus(other: Double) = map { it + other }
@JvmName("plusFloatIntSingle")
inline operator fun <reified I: Any> Series<Float, I>.plus(other: Int) = map { it + other }
@JvmName("plusFloatLongSingle")
inline operator fun <reified I: Any> Series<Float, I>.plus(other: Long) = map { it + other }
@JvmName("plusFloatSingle")
inline operator fun <reified I: Any> Series<Float, I>.plus(other: Float) = map { it + other }
@JvmName("plusFloatDoubleSingle")
inline operator fun <reified I: Any> Series<Float, I>.plus(other: Double) = map { it + other }
@JvmName("plusDoubleIntSingle")
inline operator fun <reified I: Any> Series<Double, I>.plus(other: Int) = map { it + other }
@JvmName("plusDoubleLongSingle")
inline operator fun <reified I: Any> Series<Double, I>.plus(other: Long) = map { it + other }
@JvmName("plusDoubleFloatSingle")
inline operator fun <reified I: Any> Series<Double, I>.plus(other: Float) = map { it + other }
@JvmName("plusDoubleSingle")
inline operator fun <reified I: Any> Series<Double, I>.plus(other: Double) = map { it + other }

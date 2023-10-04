package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("geInt")
inline infix fun <reified I: Any> Series<Int, I>.ge(other: Series<Int, I>) = zipMap(other, false) { a, b -> a >= b }
@JvmName("geLong")
inline infix fun <reified I: Any> Series<Long, I>.ge(other: Series<Long, I>) = zipMap(other, false) { a, b -> a >= b }
@JvmName("geFloat")
inline infix fun <reified I: Any> Series<Float, I>.ge(other: Series<Float, I>) = zipMap(other, false) { a, b -> a >= b }
@JvmName("geDouble")
inline infix fun <reified I: Any> Series<Double, I>.ge(other: Series<Double, I>) = zipMap(other, false) { a, b -> a >= b }
@JvmName("geIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.ge(other: Int) = map { it >= other }
@JvmName("geLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.ge(other: Long) = map { it >= other }
@JvmName("geFloatSingle")
inline infix fun <reified I: Any> Series<Float, I>.ge(other: Float) = map { it >= other }
@JvmName("geDoubleSingle")
inline infix fun <reified I: Any> Series<Double, I>.ge(other: Double) = map { it >= other }
@JvmName("geComparable")
inline infix fun <reified T : Comparable<T>, reified I: Any> Series<T, I>.ge(other: Series<T, I>) = zipMap(other, false) { a, b -> a >= b }
@JvmName("geComparableSingle")
inline infix fun <T : Comparable<T>, reified I: Any> Series<T, I>.ge(other: T) = map { it >= other }

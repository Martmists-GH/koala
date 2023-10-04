package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("gtInt")
inline infix fun <reified I: Any> Series<Int, I>.gt(other: Series<Int, I>) = zipMap(other, false) { a, b -> a > b }
@JvmName("gtLong")
inline infix fun <reified I: Any> Series<Long, I>.gt(other: Series<Long, I>) = zipMap(other, false) { a, b -> a > b }
@JvmName("gtFloat")
inline infix fun <reified I: Any> Series<Float, I>.gt(other: Series<Float, I>) = zipMap(other, false) { a, b -> a > b }
@JvmName("gtDouble")
inline infix fun <reified I: Any> Series<Double, I>.gt(other: Series<Double, I>) = zipMap(other, false) { a, b -> a > b }
@JvmName("gtIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.gt(other: Int) = map { it > other }
@JvmName("gtLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.gt(other: Long) = map { it > other }
@JvmName("gtFloatSingle")
inline infix fun <reified I: Any> Series<Float, I>.gt(other: Float) = map { it > other }
@JvmName("gtDoubleSingle")
inline infix fun <reified I: Any> Series<Double, I>.gt(other: Double) = map { it > other }
@JvmName("gtComparable")
inline infix fun <reified T : Comparable<T>, reified I: Any> Series<T, I>.gt(other: Series<T, I>) = zipMap(other, false) { a, b -> a > b }
@JvmName("gtComparableSingle")
inline infix fun <T : Comparable<T>, reified I: Any> Series<T, I>.gt(other: T) = map { it > other }

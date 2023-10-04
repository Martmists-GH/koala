package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("eqInt")
inline infix fun <reified I: Any> Series<Int, I>.eq(other: Series<Int, I>) = zipMap(other, false) { a, b -> a == b }
@JvmName("eqLong")
inline infix fun <reified I: Any> Series<Long, I>.eq(other: Series<Long, I>) = zipMap(other, false) { a, b -> a == b }
@JvmName("eqFloat")
inline infix fun <reified I: Any> Series<Float, I>.eq(other: Series<Float, I>) = zipMap(other, false) { a, b -> a == b }
@JvmName("eqDouble")
inline infix fun <reified I: Any> Series<Double, I>.eq(other: Series<Double, I>) = zipMap(other, false) { a, b -> a == b }
@JvmName("eqIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.eq(other: Int) = map { it == other }
@JvmName("eqLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.eq(other: Long) = map { it == other }
@JvmName("eqFloatSingle")
inline infix fun <reified I: Any> Series<Float, I>.eq(other: Float) = map { it == other }
@JvmName("eqDoubleSingle")
inline infix fun <reified I: Any> Series<Double, I>.eq(other: Double) = map { it == other }
@JvmName("eqComparable")
inline infix fun <reified T : Comparable<T>, reified I: Any> Series<T, I>.eq(other: Series<T, I>) = zipMap(other, false) { a, b -> a == b }
@JvmName("eqComparableSingle")
inline infix fun <T : Comparable<T>, reified I: Any> Series<T, I>.eq(other: T) = map { it == other }

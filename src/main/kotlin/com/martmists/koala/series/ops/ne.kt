package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("neInt")
inline infix fun <reified I: Any> Series<Int, I>.ne(other: Series<Int, I>) = zipMap(other, true) { a, b -> a != b }
@JvmName("neLong")
inline infix fun <reified I: Any> Series<Long, I>.ne(other: Series<Long, I>) = zipMap(other, true) { a, b -> a != b }
@JvmName("neFloat")
inline infix fun <reified I: Any> Series<Float, I>.ne(other: Series<Float, I>) = zipMap(other, true) { a, b -> a != b }
@JvmName("neDouble")
inline infix fun <reified I: Any> Series<Double, I>.ne(other: Series<Double, I>) = zipMap(other, true) { a, b -> a != b }
@JvmName("neIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.ne(other: Int) = map { it != other }
@JvmName("neLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.ne(other: Long) = map { it != other }
@JvmName("neFloatSingle")
inline infix fun <reified I: Any> Series<Float, I>.ne(other: Float) = map { it != other }
@JvmName("neDoubleSingle")
inline infix fun <reified I: Any> Series<Double, I>.ne(other: Double) = map { it != other }
@JvmName("neComparable")
inline infix fun <reified T : Comparable<T>, reified I: Any> Series<T, I>.ne(other: Series<T, I>) = zipMap(other, true) { a, b -> a != b }
@JvmName("neComparableSingle")
inline infix fun <T : Comparable<T>, reified I: Any> Series<T, I>.ne(other: T) = map { it != other }

package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("ltInt")
inline infix fun <reified I: Any> Series<Int, I>.lt(other: Series<Int, I>) = zipMap(other, false) { a, b -> a < b }
@JvmName("ltLong")
inline infix fun <reified I: Any> Series<Long, I>.lt(other: Series<Long, I>) = zipMap(other, false) { a, b -> a < b }
@JvmName("ltFloat")
inline infix fun <reified I: Any> Series<Float, I>.lt(other: Series<Float, I>) = zipMap(other, false) { a, b -> a < b }
@JvmName("ltDouble")
inline infix fun <reified I: Any> Series<Double, I>.lt(other: Series<Double, I>) = zipMap(other, false) { a, b -> a < b }
@JvmName("ltIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.lt(other: Int) = map { it < other }
@JvmName("ltLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.lt(other: Long) = map { it < other }
@JvmName("ltFloatSingle")
inline infix fun <reified I: Any> Series<Float, I>.lt(other: Float) = map { it < other }
@JvmName("ltDoubleSingle")
inline infix fun <reified I: Any> Series<Double, I>.lt(other: Double) = map { it < other }
@JvmName("ltComparable")
inline infix fun <reified T : Comparable<T>, reified I: Any> Series<T, I>.lt(other: Series<T, I>) = zipMap(other, false) { a, b -> a < b }
@JvmName("ltComparableSingle")
inline infix fun <T : Comparable<T>, reified I: Any> Series<T, I>.lt(other: T) = map { it < other }

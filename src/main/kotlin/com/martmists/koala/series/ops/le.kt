package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("leInt")
inline infix fun <reified I: Any> Series<Int, I>.le(other: Series<Int, I>) = zipMap(other, false) { a, b -> a <= b }
@JvmName("leLong")
inline infix fun <reified I: Any> Series<Long, I>.le(other: Series<Long, I>) = zipMap(other, false) { a, b -> a <= b }
@JvmName("leFloat")
inline infix fun <reified I: Any> Series<Float, I>.le(other: Series<Float, I>) = zipMap(other, false) { a, b -> a <= b }
@JvmName("leDouble")
inline infix fun <reified I: Any> Series<Double, I>.le(other: Series<Double, I>) = zipMap(other, false) { a, b -> a <= b }
@JvmName("leIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.le(other: Int) = map { it <= other }
@JvmName("leLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.le(other: Long) = map { it <= other }
@JvmName("leFloatSingle")
inline infix fun <reified I: Any> Series<Float, I>.le(other: Float) = map { it <= other }
@JvmName("leDoubleSingle")
inline infix fun <reified I: Any> Series<Double, I>.le(other: Double) = map { it <= other }
@JvmName("leComparable")
inline infix fun <reified T : Comparable<T>, reified I: Any> Series<T, I>.le(other: Series<T, I>) = zipMap(other, false) { a, b -> a <= b }
@JvmName("leComparableSingle")
inline infix fun <T : Comparable<T>, reified I: Any> Series<T, I>.le(other: T) = map { it <= other }

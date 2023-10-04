package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("remInt")
inline operator fun <reified I: Any> Series<Int, I>.rem(other: Series<Int, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remIntLong")
inline operator fun <reified I: Any> Series<Int, I>.rem(other: Series<Long, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remIntFloat")
inline operator fun <reified I: Any> Series<Int, I>.rem(other: Series<Float, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remIntDouble")
inline operator fun <reified I: Any> Series<Int, I>.rem(other: Series<Double, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remLongInt")
inline operator fun <reified I: Any> Series<Long, I>.rem(other: Series<Int, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remLong")
inline operator fun <reified I: Any> Series<Long, I>.rem(other: Series<Long, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remLongFloat")
inline operator fun <reified I: Any> Series<Long, I>.rem(other: Series<Float, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remLongDouble")
inline operator fun <reified I: Any> Series<Long, I>.rem(other: Series<Double, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remFloatInt")
inline operator fun <reified I: Any> Series<Float, I>.rem(other: Series<Int, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remFloatLong")
inline operator fun <reified I: Any> Series<Float, I>.rem(other: Series<Long, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remFloat")
inline operator fun <reified I: Any> Series<Float, I>.rem(other: Series<Float, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remFloatDouble")
inline operator fun <reified I: Any> Series<Float, I>.rem(other: Series<Double, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remDoubleInt")
inline operator fun <reified I: Any> Series<Double, I>.rem(other: Series<Int, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remDoubleLong")
inline operator fun <reified I: Any> Series<Double, I>.rem(other: Series<Long, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remDoubleFloat")
inline operator fun <reified I: Any> Series<Double, I>.rem(other: Series<Float, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remDouble")
inline operator fun <reified I: Any> Series<Double, I>.rem(other: Series<Double, I>) = zipMap(other) { a, b -> a % b }
@JvmName("remIntSingle")
inline operator fun <reified I: Any> Series<Int, I>.rem(other: Int) = map { it % other }
@JvmName("remIntLongSingle")
inline operator fun <reified I: Any> Series<Int, I>.rem(other: Long) = map { it % other }
@JvmName("remIntFloatSingle")
inline operator fun <reified I: Any> Series<Int, I>.rem(other: Float) = map { it % other }
@JvmName("remIntDoubleSingle")
inline operator fun <reified I: Any> Series<Int, I>.rem(other: Double) = map { it % other }
@JvmName("remLongIntSingle")
inline operator fun <reified I: Any> Series<Long, I>.rem(other: Int) = map { it % other }
@JvmName("remLongSingle")
inline operator fun <reified I: Any> Series<Long, I>.rem(other: Long) = map { it % other }
@JvmName("remLongFloatSingle")
inline operator fun <reified I: Any> Series<Long, I>.rem(other: Float) = map { it % other }
@JvmName("remLongDoubleSingle")
inline operator fun <reified I: Any> Series<Long, I>.rem(other: Double) = map { it % other }
@JvmName("remFloatIntSingle")
inline operator fun <reified I: Any> Series<Float, I>.rem(other: Int) = map { it % other }
@JvmName("remFloatLongSingle")
inline operator fun <reified I: Any> Series<Float, I>.rem(other: Long) = map { it % other }
@JvmName("remFloatSingle")
inline operator fun <reified I: Any> Series<Float, I>.rem(other: Float) = map { it % other }
@JvmName("remFloatDoubleSingle")
inline operator fun <reified I: Any> Series<Float, I>.rem(other: Double) = map { it % other }
@JvmName("remDoubleIntSingle")
inline operator fun <reified I: Any> Series<Double, I>.rem(other: Int) = map { it % other }
@JvmName("remDoubleLongSingle")
inline operator fun <reified I: Any> Series<Double, I>.rem(other: Long) = map { it % other }
@JvmName("remDoubleFloatSingle")
inline operator fun <reified I: Any> Series<Double, I>.rem(other: Float) = map { it % other }
@JvmName("remDoubleSingle")
inline operator fun <reified I: Any> Series<Double, I>.rem(other: Double) = map { it % other }

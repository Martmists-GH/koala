package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("andInt")
inline infix fun <reified I: Any> Series<Int, I>.and(other: Series<Int, I>) = zipMap(other) { a, b -> a and b }
@JvmName("andLong")
inline infix fun <reified I: Any> Series<Long, I>.and(other: Series<Long, I>) = zipMap(other) { a, b -> a and b }
@JvmName("andIntSingle")
infix fun <I: Any> Series<Int, I>.and(other: Int) = map { it and other }
@JvmName("andLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.and(other: Long) = map { it and other }

@JvmName("orInt")
inline infix fun <reified I: Any> Series<Int, I>.or(other: Series<Int, I>) = zipMap(other) { a, b -> a or b }
@JvmName("orLong")
inline infix fun <reified I: Any> Series<Long, I>.or(other: Series<Long, I>) = zipMap(other) { a, b -> a or b }
@JvmName("orIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.or(other: Int) = map { it or other }
@JvmName("orLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.or(other: Long) = map { it or other }

@JvmName("xorInt")
inline infix fun <reified I: Any> Series<Int, I>.xor(other: Series<Int, I>) = zipMap(other) { a, b -> a xor b }
@JvmName("xorLong")
inline infix fun <reified I: Any> Series<Long, I>.xor(other: Series<Long, I>) = zipMap(other) { a, b -> a xor b }
@JvmName("xorIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.xor(other: Int) = map { it xor other }
@JvmName("xorLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.xor(other: Long) = map { it xor other }

@JvmName("shlInt")
inline infix fun <reified I: Any> Series<Int, I>.shl(other: Series<Int, I>) = zipMap(other) { a, b -> a shl b }
@JvmName("shlLong")
inline infix fun <reified I: Any> Series<Long, I>.shl(other: Series<Int, I>) = zipMap(other) { a, b -> a shl b }
@JvmName("shlIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.shl(other: Int) = map { it shl other }
@JvmName("shlLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.shl(other: Int) = map { it shl other }

@JvmName("shrInt")
inline infix fun <reified I: Any> Series<Int, I>.shr(other: Series<Int, I>) = zipMap(other) { a, b -> a shr b }
@JvmName("shrLong")
inline infix fun <reified I: Any> Series<Long, I>.shr(other: Series<Int, I>) = zipMap(other) { a, b -> a shr b }
@JvmName("shrIntSingle")
inline infix fun <reified I: Any> Series<Int, I>.shr(other: Int) = map { it shr other }
@JvmName("shrLongSingle")
inline infix fun <reified I: Any> Series<Long, I>.shr(other: Int) = map { it shr other }

@JvmName("invInt")
inline fun <reified I: Any> Series<Int, I>.inv() = map { it.inv() }
@JvmName("invLong")
inline fun <reified I: Any> Series<Long, I>.inv() = map { it.inv() }

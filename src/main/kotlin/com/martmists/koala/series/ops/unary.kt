package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

@JvmName("unaryMinusInt")
inline operator fun <reified I: Any> Series<Int, I>.unaryMinus() = map { -it }
@JvmName("unaryMinusLong")
inline operator fun <reified I: Any> Series<Long, I>.unaryMinus() = map { -it }
@JvmName("unaryMinusFloat")
inline operator fun <reified I: Any> Series<Float, I>.unaryMinus() = map { -it }
@JvmName("unaryMinusDouble")
inline operator fun <reified I: Any> Series<Double, I>.unaryMinus() = map { -it }

inline operator fun <reified I: Any> Series<Boolean, I>.not() = map { !it }

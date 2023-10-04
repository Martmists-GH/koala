package com.martmists.koala.series.ops

import com.martmists.koala.series.Series
import com.martmists.koala.series.SingleValueWrappedSeries
import kotlin.reflect.typeOf

@JvmName("isnaFloat")
fun <I: Any> Series<Float, I>.isna() = map { it.isNaN() }
@JvmName("isnaDouble")
fun <I: Any> Series<Double, I>.isna() = map { it.isNaN() }
@Suppress("UNCHECKED_CAST")
@JvmName("isnaT")
fun <T: Any, I: Any> Series<T, I>.isna(): Series<Boolean, I> {
    return when (dtype) {
        typeOf<Float>() -> {
            (this as Series<Float, I>).map { it.isNaN() }
        }
        typeOf<Double>() -> {
            (this as Series<Double, I>).map { it.isNaN() }
        }
        else -> {
            SingleValueWrappedSeries(false, index)
        }
    }
}
@JvmName("isnaTNullable")
fun <T, I: Any> Series<T?, I>.isna() = map { it == null }

@JvmName("notnaFloat")
fun <I: Any> Series<Float, I>.notna() = map { !it.isNaN() }
@JvmName("notnaDouble")
fun <I: Any> Series<Double, I>.notna() = map { !it.isNaN() }
@Suppress("UNCHECKED_CAST")
@JvmName("notnaT")
fun <T: Any, I: Any> Series<T, I>.notna(): Series<Boolean, I> {
    return when (dtype) {
        typeOf<Float>() -> {
            (this as Series<Float, I>).map { !it.isNaN() }
        }
        typeOf<Double>() -> {
            (this as Series<Double, I>).map { !it.isNaN() }
        }
        else -> {
            SingleValueWrappedSeries(true, index)
        }
    }
}
@JvmName("notnaTNullable")
fun <T, I: Any> Series<T?, I>.notna() = map { it != null }

@JvmName("fillnaFloat")
inline fun <reified I: Any> Series<Float, I>.fillna(value: Float) = map { if (it.isNaN()) value else it }
@JvmName("fillnaFloatNullable")
inline fun <reified I: Any> Series<Float?, I>.fillna(value: Float) = map { if (it == null || it.isNaN()) value else it }
@JvmName("fillnaDouble")
inline fun <reified I: Any> Series<Double, I>.fillna(value: Double) = map { if (it.isNaN()) value else it }
@JvmName("fillnaDoubleNullable")
inline fun <reified I: Any> Series<Double?, I>.fillna(value: Double) = map { if (it == null || it.isNaN()) value else it }
@JvmName("fillnaInt")
inline fun <reified I: Any> Series<Int?, I>.fillna(value: Int) = map { it ?: value }
@JvmName("fillnaLong")
inline fun <reified I: Any> Series<Long?, I>.fillna(value: Long) = map { it ?: value }
@JvmName("fillnaT")
inline fun <reified T, I: Any> Series<T?, I>.fillna(value: T) = map { it ?: value }

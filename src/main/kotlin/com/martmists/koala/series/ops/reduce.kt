package com.martmists.koala.series.ops

import com.martmists.koala.series.Series

fun <T, I: Any, X> Series<T, I>.reduce(initialValue: X, operation: (X, T) -> X): X {
    var accumulator = initialValue
    for (element in this) {
        accumulator = operation(accumulator, element)
    }
    return accumulator
}

fun <T, I: Any> Series<T, I>.reduce(operation: (T, T) -> T): T {
    if (size == 0) throw NoSuchElementException("Empty series can't be reduced.")
    val iterator = iterator()
    var accumulator = iterator.next()
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
    }
    return accumulator
}

// Common reductions

@JvmName("sumInt")
fun <I: Any> Series<Int, I>.sum() = reduce { a, b -> a + b }
@JvmName("sumLong")
fun <I: Any> Series<Long, I>.sum() = reduce { a, b -> a + b }
@JvmName("sumFloat")
fun <I: Any> Series<Float, I>.sum() = reduce { a, b -> a + b }
@JvmName("sumDouble")
fun <I: Any> Series<Double, I>.sum() = reduce { a, b -> a + b }
@JvmName("sumOfInt")
fun <T, I: Any> Series<T, I>.sumOf(selector: (T) -> Int) = reduce(0) { a, b -> a + selector(b) }
@JvmName("sumOfLong")
fun <T, I: Any> Series<T, I>.sumOf(selector: (T) -> Long) = reduce(0L) { a, b -> a + selector(b) }
@JvmName("sumOfFloat")
fun <T, I: Any> Series<T, I>.sumOf(selector: (T) -> Float) = reduce(0F) { a, b -> a + selector(b) }
@JvmName("sumOfDouble")
fun <T, I: Any> Series<T, I>.sumOf(selector: (T) -> Double) = reduce(0.0) { a, b -> a + selector(b) }

@JvmName("minInt")
fun <I: Any> Series<Int, I>.min() = reduce { a, b -> minOf(a, b) }
@JvmName("minLong")
fun <I: Any> Series<Long, I>.min() = reduce { a, b -> minOf(a, b) }
@JvmName("minFloat")
fun <I: Any> Series<Float, I>.min() = reduce { a, b -> minOf(a, b) }
@JvmName("minDouble")
fun <I: Any> Series<Double, I>.min() = reduce { a, b -> minOf(a, b) }
@JvmName("minComparable")
fun <T : Comparable<T>, I: Any> Series<T, I>.min() = reduce { a, b -> if (a < b) a else b }
fun <T, C : Comparable<C>, I: Any> Series<T, I>.minBy(selector: (T) -> C) = reduce { a, b -> if (selector(a) < selector(b)) a else b }  // TODO: Could be defined directly to use half the selector() calls

@JvmName("maxInt")
fun <I: Any> Series<Int, I>.max() = reduce { a, b -> maxOf(a, b) }
@JvmName("maxLong")
fun <I: Any> Series<Long, I>.max() = reduce { a, b -> maxOf(a, b) }
@JvmName("maxFloat")
fun <I: Any> Series<Float, I>.max() = reduce { a, b -> maxOf(a, b) }
@JvmName("maxDouble")
fun <I: Any> Series<Double, I>.max() = reduce { a, b -> maxOf(a, b) }
@JvmName("maxComparable")
fun <T : Comparable<T>, I: Any> Series<T, I>.max() = reduce { a, b -> if (a > b) a else b }
fun <T, C : Comparable<C>, I: Any> Series<T, I>.maxBy(selector: (T) -> C) = reduce { a, b -> if (selector(a) > selector(b)) a else b }  // TODO: Could be defined directly to use half the selector() calls

@JvmName("averageInt")
fun <I: Any> Series<Int, I>.average() = sum() / size
@JvmName("averageLong")
fun <I: Any> Series<Long, I>.average() = sum() / size
@JvmName("averageFloat")
fun <I: Any> Series<Float, I>.average() = sum() / size
@JvmName("averageDouble")
fun <I: Any> Series<Double, I>.average() = sum() / size

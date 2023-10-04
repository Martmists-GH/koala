package com.martmists.koala.series.ops

import com.martmists.koala.series.*

fun <I: Any> Series<Double, I>.shift(by: Int = 1): Series<Double, I> {
    val newValues = DoubleArray(size) {
        if (by > 0) {
            if (it < size - by) {
                values[it + by]
            } else {
                Double.NaN
            }
        } else {
            if (it < -by) {
                Double.NaN
            } else {
                values[it + by]
            }
        }
    }
    return DoubleSeries(newValues, index)
}

fun <I: Any> Series<Float, I>.shift(by: Int = 1): Series<Float, I> {
    val newValues = FloatArray(size) {
        if (by > 0) {
            if (it < size - by) {
                values[it + by]
            } else {
                Float.NaN
            }
        } else {
            if (it < -by) {
                Float.NaN
            } else {
                values[it + by]
            }
        }
    }
    return FloatSeries(newValues, index)
}

fun <I: Any> Series<Int, I>.shift(by: Int = 1, fill: Int): Series<Int, I> {
    val newValues = IntArray(size) {
        if (by > 0) {
            if (it < size - by) {
                values[it + by]
            } else {
                fill
            }
        } else {
            if (it < -by) {
                fill
            } else {
                values[it + by]
            }
        }
    }
    return IntSeries(newValues, index)
}

fun <I: Any> Series<Long, I>.shift(by: Int = 1, fill: Long): Series<Long, I> {
    val newValues = LongArray(size) {
        if (by > 0) {
            if (it < size - by) {
                values[it + by]
            } else {
                fill
            }
        } else {
            if (it < -by) {
                fill
            } else {
                values[it + by]
            }
        }
    }
    return LongSeries(newValues, index)
}

inline fun <reified T, I: Any> Series<T, I>.shift(by: Int = 1): Series<T?, I> {
    val newValues = (values as Array<T?>).copyOf()
    if (by > 0) {
        for (i in 0 until size - by) {
            newValues[i] = values[i + by]
        }
        for (i in size - by until size) {
            newValues[i] = null
        }
    } else {
        for (i in size - 1 downTo -by) {
            newValues[i] = values[i + by]
        }
        for (i in 0 until -by) {
            newValues[i] = null
        }
    }
    return CollectionSeries(newValues, index)
}

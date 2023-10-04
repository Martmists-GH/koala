import com.martmists.koala.series.CollectionSeries
import com.martmists.koala.*
import com.martmists.koala.index.CollectionIndex
import com.martmists.koala.series.DoubleSeries
import com.martmists.koala.series.IntSeries
import com.martmists.koala.series.ops.div
import com.martmists.koala.series.ops.gt
import com.martmists.koala.series.ops.plus
import kotlin.random.Random
import kotlin.test.*
import kotlin.time.measureTime

fun Array<Double>.percentile(p: Int) = sorted()[((size - 1) * p) / 100]

class SimpleTest {
    @Test
    fun `Basic Dataframe Test`() {
        println("Basic Dataframe Test")

        val size = 1_000
        val times = 1_000_000

        val df = DataFrame()
        val col1 = Array(size) { Random.nextInt() }
        val col2 = Array(size) { Random.nextDouble() }
        df["col1"] = IntSeries(col1)
        df["col2"] = DoubleSeries(col2)

        val results = Array(times) {
            measureTime {
                df["col3"] = df.get<Int>("col1") + df.get<Double>("col2")
                df["col4"] = df.get<Double>("col3") / df.get<Int>("col1")
            }.inWholeNanoseconds / 1_000.0
        }

        val arrayResults = Array(times) {
            measureTime {
                val col3 = Array(size) { col1[it] + col2[it] }
                val col4 = Array(size) { col3[it] / col1[it] }
            }.inWholeNanoseconds / 1_000.0
        }

        println("mean: ${results.average()}us (array: ${arrayResults.average()}us)")
        println("min: ${results.min()}us (array: ${arrayResults.min()}us)")
        println("max: ${results.max()}us (array: ${arrayResults.max()}us)")
        println("p50: ${results.percentile(50)}us (array: ${arrayResults.percentile(50)}us)")
        println("p90: ${results.percentile(90)}us (array: ${arrayResults.percentile(90)}us)")
        println("p99: ${results.percentile(99)}us (array: ${arrayResults.percentile(99)}us)")
    }

    @Test
    fun `Series with different index`() {
        println("Series with different index")

        val size = 1_000
        val times = 1_000_000

        val col1 = Array(size) { Random.nextInt() }
        val col2 = Array(size) { Random.nextDouble() }
        val s1 = IntSeries(col1)
        val s2 = DoubleSeries(col2, CollectionIndex(Array(size) { it * 2 }))

        val results = Array(times) {
            measureTime {
                s1 + s2
            }.inWholeNanoseconds / 1_000.0
        }

        val arrayResults = Array(times) {
            measureTime {
                val col3 = Array(size) { col1[it] + col2[it] }
            }.inWholeNanoseconds / 1_000.0
        }

        println("mean: ${results.average()}us (array: ${arrayResults.average()}us)")
        println("min: ${results.min()}us (array: ${arrayResults.min()}us)")
        println("max: ${results.max()}us (array: ${arrayResults.max()}us)")
        println("p50: ${results.percentile(50)}us (array: ${arrayResults.percentile(50)}us)")
        println("p90: ${results.percentile(90)}us (array: ${arrayResults.percentile(90)}us)")
        println("p99: ${results.percentile(99)}us (array: ${arrayResults.percentile(99)}us)")
    }

    @Test
    fun `Indexing by comparison`() {
        println("Indexing things")

        val col1 = Array(1_000_000) { Random.nextDouble() }
        val col2 = Array(1_000_000) { Random.nextDouble() }
        val col3 = Array(1_000_000) { Random.nextDouble() }

        val df = DataFrame()
        df["col1"] = DoubleSeries(col1)
        df["col2"] = DoubleSeries(col2)
        df["col3"] = DoubleSeries(col3)

        val results = Array(1_000) {
            measureTime {
                df[df.get<Double>("col1") gt df.get<Double>("col2"), "col3"]
            }.inWholeNanoseconds / 1_000.0
        }

        val arrayResults = Array(1_000) {
            measureTime {
                val col4 = Array(1_000) {
                    if (col1[it] > col2[it]) {
                        col3[it]
                    } else {
                        null
                    }
                }.filterNotNull()
            }.inWholeNanoseconds / 1_000.0
        }

        println("mean: ${results.average()}us (array: ${arrayResults.average()}us)")
        println("min: ${results.min()}us (array: ${arrayResults.min()}us)")
        println("max: ${results.max()}us (array: ${arrayResults.max()}us)")
        println("p50: ${results.percentile(50)}us (array: ${arrayResults.percentile(50)}us)")
        println("p90: ${results.percentile(90)}us (array: ${arrayResults.percentile(90)}us)")
        println("p99: ${results.percentile(99)}us (array: ${arrayResults.percentile(99)}us)")
    }

    @Test
    fun `Comparisons (Double)`() {
        println("Comparisons (Double)")

        val col1 = Array(1_000_000) { Random.nextDouble() }
        val col2 = Array(1_000_000) { Random.nextDouble() }

        val df = DataFrame()
        df["col1"] = DoubleSeries(col1)
        df["col2"] = DoubleSeries(col2)

        val results = Array(1_000) {
            measureTime {
                df.get<Double>("col1") gt df.get<Double>("col2")
            }.inWholeNanoseconds / 1_000.0
        }

        val arrayResults = Array(1_000) {
            measureTime {
                val col3 = Array(1_000_000) {
                    col1[it] > col2[it]
                }
            }.inWholeNanoseconds / 1_000.0
        }

        println("mean: ${results.average()}us (array: ${arrayResults.average()}us)")
        println("min: ${results.min()}us (array: ${arrayResults.min()}us)")
        println("max: ${results.max()}us (array: ${arrayResults.max()}us)")
        println("p50: ${results.percentile(50)}us (array: ${arrayResults.percentile(50)}us)")
        println("p90: ${results.percentile(90)}us (array: ${arrayResults.percentile(90)}us)")
        println("p99: ${results.percentile(99)}us (array: ${arrayResults.percentile(99)}us)")
    }

    @Test
    fun `Comparisons (Int)`() {
        println("Comparisons (Int)")

        val col1 = Array(1_000_000) { Random.nextInt() }
        val col2 = Array(1_000_000) { Random.nextInt() }

        val df = DataFrame()
        df["col1"] = IntSeries(col1)
        df["col2"] = IntSeries(col2)

        val results = Array(1_000) {
            measureTime {
                df.get<Int>("col1") gt df.get<Int>("col2")
            }.inWholeNanoseconds / 1_000.0
        }

        val arrayResults = Array(1_000) {
            measureTime {
                val col3 = Array(1_000_000) {
                    col1[it] > col2[it]
                }
            }.inWholeNanoseconds / 1_000.0
        }

        println("mean: ${results.average()}us (array: ${arrayResults.average()}us)")
        println("min: ${results.min()}us (array: ${arrayResults.min()}us)")
        println("max: ${results.max()}us (array: ${arrayResults.max()}us)")
        println("p50: ${results.percentile(50)}us (array: ${arrayResults.percentile(50)}us)")
        println("p90: ${results.percentile(90)}us (array: ${arrayResults.percentile(90)}us)")
        println("p99: ${results.percentile(99)}us (array: ${arrayResults.percentile(99)}us)")
    }
}

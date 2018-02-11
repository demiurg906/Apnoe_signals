package com.medical.signals.signalsapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BaseSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.medical.signals.signalsapp.data.*
import java.util.concurrent.ConcurrentLinkedDeque
import kotlin.concurrent.thread

class GraphsActivity : AppCompatActivity() {
    companion object {
        private const val INITIAL_DATA = 10
        private const val MAX_DATA_POINT = 60
        private const val MAX_X_BOUND = 60.0

        private const val TASK_HANDLER_DELAY: Long = 500

        private val sensorColors = mapOf(
                Pair(SensorType.BP, Color.BLUE),
                Pair(SensorType.ECG, Color.RED),
                Pair(SensorType.SO2, Color.YELLOW),
                Pair(SensorType.Rest1, Color.CYAN),
                Pair(SensorType.Rest2, Color.GREEN)
        )

        private enum class ScaleType {Big, Small}

        private val sensorSizes = mapOf(
                SensorType.BP to ScaleType.Big,
                SensorType.ECG to ScaleType.Small,
                SensorType.SO2 to ScaleType.Big,
                SensorType.Rest1 to ScaleType.Small,
                SensorType.Rest2 to ScaleType.Small
        )

        private val maxYBoundaries = mapOf(
                ScaleType.Big to 150.0,
                ScaleType.Small to 0.4
        )
    }

    private val dataProvider: DataProvider = DummyDataProvider(MyDataEventListener(this), INITIAL_DATA)
    private val graphSeries: Map<SensorType, BaseSeries<DataPoint>>

    private val tasks = ConcurrentLinkedDeque<DataPackage>()
    private val tasksHandler: Thread

    init {
        val series = mutableMapOf<SensorType, BaseSeries<DataPoint>>()
        for (sensor in SensorType.values()) {
            series[sensor] = LineGraphSeries<DataPoint>()
        }
        this.graphSeries = series

        tasksHandler = thread(start = false) {
            while (true) {
                if (tasks.isEmpty()) {
                    Thread.sleep(TASK_HANDLER_DELAY)
                    continue
                }
                val data = tasks.removeFirst()
                runOnUiThread {
                    val series = graphSeries[data.sensor] ?: return@runOnUiThread
                    series.appendData(DataPoint(data.time, data.value), true, GraphsActivity.MAX_DATA_POINT)
                }
            }
        }
    }

    private class MyDataEventListener(val activity: GraphsActivity) : DataEventListener {
        override fun onNewData(data: DataPackage) {
            activity.tasks.addLast(data)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graphs)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        startServing()
    }

    private fun startServing() {
        val graph = findViewById<GraphView>(R.id.graph)

        with (graph.viewport) {
            isXAxisBoundsManual = true
            setMinX(0.0)
            setMaxX(MAX_X_BOUND)
            isYAxisBoundsManual = true
            setMinY(0.0)
            setMaxY(maxYBoundaries[ScaleType.Small]!!)

            isScrollable = true
            setScrollableY(true)
        }

        with(graph.secondScale) {
            setMinY(0.0)
            setMaxY(maxYBoundaries[ScaleType.Big]!!)
        }

        val signals = dataProvider.getInitialSignals()
        for ((sensor, data) in signals.entries) {
            val size = sensorSizes[sensor] ?: throw RuntimeException("curious")
            val series = graphSeries[sensor] ?: throw RuntimeException("Curious")
            data.forEach { series.appendData(DataPoint(it.time, it.value), false, MAX_DATA_POINT) }
            series.color = sensorColors[sensor] ?: throw RuntimeException("Curious")
            if (size == ScaleType.Small) {
                graph.addSeries(series)
            } else {
                graph.secondScale.addSeries(series)
            }
        }
        tasksHandler.start()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}

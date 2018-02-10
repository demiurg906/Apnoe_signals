package com.medical.signals.signalsapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BaseSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.medical.signals.signalsapp.data.*

class GraphsActivity : AppCompatActivity() {
    companion object {
        private const val INITIAL_DATA = 10
        private const val MAX_DATA_POINT = 60
        private const val MAX_X_BOUND = 30.0

        private val sensorColors = mapOf(
                Pair(SensorType.BP, Color.BLUE),
                Pair(SensorType.ECG, Color.RED),
                Pair(SensorType.SO2, Color.YELLOW),
                Pair(SensorType.Rest1, Color.CYAN),
                Pair(SensorType.Rest2, Color.GREEN)
        )

        private enum class ScaleType {Big, Small}

        private val componentsMap = mapOf(
                ScaleType.Big to R.id.graph_big,
                ScaleType.Small to R.id.graph_small
        )

        private val sensorSizes = mapOf(
                SensorType.BP to ScaleType.Big,
                SensorType.ECG to ScaleType.Small,
                SensorType.SO2 to ScaleType.Big,
                SensorType.Rest1 to ScaleType.Small,
                SensorType.Rest2 to ScaleType.Small
        )
    }

    private val dataProvider: DataProvider = DummyDataProvider(MyDataEventListener(this), INITIAL_DATA)
    private val graphSeries: Map<SensorType, BaseSeries<DataPoint>>

    init {
        val series = mutableMapOf<SensorType, BaseSeries<DataPoint>>()
        for (sensor in SensorType.values()) {
            series[sensor] = LineGraphSeries<DataPoint>()
        }
        this.graphSeries = series
    }

    private class MyDataEventListener(val activity: GraphsActivity) : DataEventListener {
        override fun onNewData(data: DataPackage) {
            val series = activity.graphSeries[data.sensor] ?: throw RuntimeException("Curious")
            series.appendData(DataPoint(data.time, data.value), true, GraphsActivity.MAX_DATA_POINT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graphs)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            makeGraph()
        }
    }

    private fun makeGraph() {
        componentsMap.values.forEach {
            val graph = findViewById<GraphView>(it)
            graph.viewport.isXAxisBoundsManual = true
            graph.viewport.setMinX(0.0)
            graph.viewport.setMaxX(MAX_X_BOUND)
        }

        val signals = dataProvider.getInitialSignals()
        for ((sensor, data) in signals.entries) {
            val size = sensorSizes[sensor] ?: throw RuntimeException("curious")
            val graph = findViewById<GraphView>(componentsMap[size] ?: -1)
            val series = graphSeries[sensor] ?: throw RuntimeException("Curious")
            data.forEach { series.appendData(DataPoint(it.time, it.value), true, MAX_DATA_POINT) }
            series.color = sensorColors[sensor] ?: throw RuntimeException("Curious")
            graph.addSeries(series)
        }
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

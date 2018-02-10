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
        private const val TIME = 0
        private const val BP = 1
        private const val ECG = 2
        private const val SO2 = 3
        private const val REST1 = 4
        private const val REST2 = 5

        private const val INITIAL_DATA = 20

        private const val MAX_DATA_POINT = 100

        private val sensorColors = mapOf(
                Pair(SensorType.BP, Color.BLUE),
                Pair(SensorType.ECG, Color.RED),
                Pair(SensorType.SO2, Color.YELLOW),
                Pair(SensorType.Rest1, Color.CYAN),
                Pair(SensorType.Rest2, Color.GREEN)
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
        val graph = findViewById<GraphView>(R.id.graph)
        graph.viewport.isXAxisBoundsManual = true
        graph.viewport.setMinX(0.0)
        graph.viewport.setMaxX(30.0)
        val signals = dataProvider.getInitialSignals()
        for ((sensor, data) in signals.entries) {
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

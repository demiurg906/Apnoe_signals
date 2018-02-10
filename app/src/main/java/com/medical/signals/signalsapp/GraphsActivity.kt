package com.medical.signals.signalsapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class GraphsActivity : AppCompatActivity() {
    private val TIME = 0
    private val BP = 1
    private val ECG = 2
    private val SO2 = 3
    private val REST1 = 4
    private val REST2 = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graphs)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            val signals = DummyDataProvider().readAllSignals()
            makeGraph(signals)
        }
    }

    private fun makeGraph(signals: List<List<Double>>) {
        val graph = findViewById<GraphView>(R.id.graph)

        val n = signals.size

        addSeries(signals, graph, n, BP, Color.BLUE)
        addSeries(signals, graph, n, ECG, Color.RED)
        addSeries(signals, graph, n, SO2, Color.YELLOW)
        addSeries(signals, graph, n, REST1, Color.CYAN)
        addSeries(signals, graph, n, REST2, Color.GREEN)

    }

    private fun addSeries(signals: List<List<Double>>, graph: GraphView, n: Int, data: Int, color: Int) {
        val points = arrayOfNulls<DataPoint>(n)
        for (i in 0 until n) {
            points[i] = DataPoint(signals[i][TIME], signals[i][data])
        }
        val series = LineGraphSeries<DataPoint>(points)
        graph.addSeries(series)
        series.color = color
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

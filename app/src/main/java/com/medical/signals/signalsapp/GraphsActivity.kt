package com.medical.signals.signalsapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList

class GraphsActivity : AppCompatActivity() {
    private val SIGNALS_FILENAME = "signals/signals.txt"
    private val TIME = 0
    private val BP = 1
    private val ECG = 2
    private val SO2 = 3
    private val REST1 = 4
    private val REST2 = 5

    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_graphs)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            val signals = readSignals()
            if (signals != null) {
                makeGraph(signals)

            } else {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
        }
    }

    private fun makeGraph(signals: List<List<Double>>) {
        val graph = findViewById<GraphView>(R.id.graph)

        val n = signals.size
        //        int n = 10;
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

    private fun readSignals(): List<List<Double>>? {
        val sdcard = Environment.getExternalStorageDirectory()
        val file = File(sdcard, SIGNALS_FILENAME)
        val signals = ArrayList<List<Double>>()
        try {
            val reader = BufferedReader(FileReader(file))
            val headers = reader.readLine()
            var line = reader.readLine()
            while (line != null) {
                val values = line.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val row = ArrayList<Double>()
                for (value in values) {
                    row.add(java.lang.Double.parseDouble(value))
                }
                signals.add(row)
                line = reader.readLine()
            }
            reader.close()
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

        return signals
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

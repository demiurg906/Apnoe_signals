package com.medical.signals.signalsapp.data

//import android.os.Environment
//import java.io.BufferedReader
//import java.io.File
//import java.io.FileReader
//import java.io.IOException
//import java.util.ArrayList
//
//class FileDataProvider(val signalsFilename: String) : DataProvider {
//    private val SIGNALS_FILENAME = "signals/signals.txt"
//
//    override fun readAllSignals(n: Int): List<List<Double>> {
//        val sdcard = Environment.getExternalStorageDirectory()
//        val file = File(sdcard, signalsFilename)
//        val signals = ArrayList<List<Double>>()
//        try {
//            val reader = BufferedReader(FileReader(file))
//            val headers = reader.readLine()
//            var line = reader.readLine()
//            while (line != null) {
//                val values = line.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//                val row = ArrayList<Double>()
//                for (value in values) {
//                    row.add(java.lang.Double.parseDouble(value))
//                }
//                signals.add(row)
//                line = reader.readLine()
//            }
//            reader.close()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//
//        return signals
//    }
//}
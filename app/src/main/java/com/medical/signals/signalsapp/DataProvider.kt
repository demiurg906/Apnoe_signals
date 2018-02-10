package com.medical.signals.signalsapp

/**
 * Created by demiurg on 10.02.2018.
 */
interface DataProvider {
    fun readAllSignals(n: Int = 0): List<List<Double>>
}
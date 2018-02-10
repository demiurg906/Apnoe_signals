package com.medical.signals.signalsapp.data

abstract class DataProvider {
    protected val listeners = mutableListOf<DataEventListener>()

    abstract fun getInitialSignals(): Map<SensorType, List<DataPackage>>

    fun addNewDataEventListener(listener: DataEventListener) {
        listeners.add(listener)
    }

    protected fun fireEvent(data: DataPackage) {
        listeners.forEach { it.onNewData(data) }
    }
}
package com.medical.signals.signalsapp.data

interface DataEventListener {
    fun onNewData(data: DataPackage)
}
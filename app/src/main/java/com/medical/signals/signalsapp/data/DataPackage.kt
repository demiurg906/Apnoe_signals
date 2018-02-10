package com.medical.signals.signalsapp.data

enum class SensorType {
    Time, BP, ECG, SO2, Rest1, Rest2
}

data class DataPackage(
        val time: Double,
        val value: Double,
        val sensor: SensorType
)
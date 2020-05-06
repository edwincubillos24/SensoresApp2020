package com.edwinacubillos.sensoresapp2020

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_orientacion.view.*

/**
 * A simple [Fragment] subclass.
 */
class OrientacionFragment : Fragment(), SensorEventListener {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_orientacion, container, false)

        val sensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val listSensores: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION)

        if (listSensores.isNotEmpty()) {
            val sensor = listSensores[0]
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            val infoSensor =
                "Nombre: " + sensor.name + "\nResolución: " + sensor.resolution + "\nRango Máximo: " + sensor.maximumRange
            rootView.info.text = infoSensor
        } else {
            rootView.info.text = "No tiene sensor de orientación"
        }
        return rootView
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == Sensor.TYPE_ORIENTATION)
            rootView.tv_salida.text =
                "X = " + event.values[0] + "\nY = " + event.values[1] + "\nZ = " + event.values[2]
    }
}

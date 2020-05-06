package com.edwinacubillos.sensoresapp2020

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_acelerometro.view.*
import kotlinx.android.synthetic.main.fragment_acelerometro.view.info
import kotlinx.android.synthetic.main.fragment_acelerometro.view.tv_salida
import kotlinx.android.synthetic.main.fragment_magnetico.view.*

/**
 * A simple [Fragment] subclass.
 */
class AcelerometroFragment : Fragment(), SensorEventListener {

    private lateinit var rootView : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_acelerometro, container, false)

        val sensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val listSensores: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER)

        if (listSensores.isNotEmpty()) {
            val sensor = listSensores[0]
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            val infoSensor =
                "Nombre: " + sensor.name + "\nResolución: " + sensor.resolution + "\nRango Máximo: " + sensor.maximumRange
            rootView.info.text = infoSensor
        } else {
            rootView.info.text = "No tiene acelerometro"
        }
        return rootView
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == Sensor.TYPE_ACCELEROMETER)
            rootView.tv_salida.text = "X = "+ event!!.values[0] + "\nY = "+ event.values[1] + "\nZ = "+ event.values[2]
    }
}

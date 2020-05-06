package com.edwinacubillos.sensoresapp2020

import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_busqueda_sensores.view.*

/**
 * A simple [Fragment] subclass.
 */
class BusquedaSensoresFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_busqueda_sensores, container, false)

        val sensorManager = activity?.getSystemService(SENSOR_SERVICE) as SensorManager
        val listSensores: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        var cont = 1
        for(sensor in listSensores){
            view.tv_listSensores.append(cont.toString()+"- "+sensor.name + "\n")
            cont++
        }

        return view
    }
}

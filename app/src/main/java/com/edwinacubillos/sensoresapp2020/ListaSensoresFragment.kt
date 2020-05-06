package com.edwinacubillos.sensoresapp2020

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_lista_sensores.view.*

/**
 * A simple [Fragment] subclass.
 */
class ListaSensoresFragment : Fragment(), SensoresRVAdapter.OnItemClickListener {

    private lateinit var sensorList: MutableList<Sensores>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista_sensores, container, false)

        loadList()

        view.rv_sensores.setHasFixedSize(true)
        view.rv_sensores.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        view.rv_sensores.adapter = SensoresRVAdapter(sensorList as ArrayList, this)

        return view
    }

    fun loadList() {
        sensorList = ArrayList()
        sensorList.add(
            Sensores(
                1,
                R.drawable.ic_sensor, "Buscar Sensores"
            )
        )
        sensorList.add(
            Sensores(
                2,
                R.drawable.magnetic, "Campo Magnético"
            )
        )
        sensorList.add(
            Sensores(
                3,
                R.drawable.proximity, "Proximidad"
            )
        )
        sensorList.add(
            Sensores(
                4,
                R.drawable.light, "Luz"
            )
        )
        sensorList.add(
            Sensores(
                5,
                R.drawable.ic_acelerometro, "Acelerometro"
            )
        )
        sensorList.add(
            Sensores(
                6,
                R.drawable.rotation, "Rotación"
            )
        )
        sensorList.add(
            Sensores(
                7,
                R.drawable.orientation, "Orientación"
            )
        )
    }

    override fun onItemClick(sensor: Sensores) {
        when (sensor.id) {
            1 -> findNavController().navigate(R.id.action_listaSensoresFragment_to_busquedaSensoresFragment)
            2 -> findNavController().navigate(R.id.action_listaSensoresFragment_to_magneticoFragment)
            3 -> findNavController().navigate(R.id.action_listaSensoresFragment_to_proximidadFragment)
            4 -> findNavController().navigate(R.id.action_listaSensoresFragment_to_luzFragment)
            5 -> findNavController().navigate(R.id.action_listaSensoresFragment_to_acelerometroFragment)
            6 -> findNavController().navigate(R.id.action_listaSensoresFragment_to_rotacionFragment)
            else -> findNavController().navigate(R.id.action_listaSensoresFragment_to_orientacionFragment)
        }
    }
}

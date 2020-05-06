package com.edwinacubillos.sensoresapp2020

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sensor_item.view.*

class SensoresRVAdapter(
    var sensorList: ArrayList<Sensores>,
    val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<SensoresRVAdapter.SensorViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SensorViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.sensor_item, parent, false)
        return SensorViewHolder(itemView,  onItemClickListener)
    }

    override fun getItemCount(): Int {
        return sensorList.size
    }

    override fun onBindViewHolder(
        holder: SensorViewHolder,
        position: Int
    ) {
        val sensor: Sensores = sensorList[position]
        holder.bindFuncion(sensor)
    }

    class SensorViewHolder(
        itemView: View,
        var onItemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private lateinit var sensor: Sensores

        fun bindFuncion(sensor: Sensores) {
            this.sensor = sensor
            itemView.tv_sensor.text = sensor.nombre
            itemView.iv_icono.setImageResource(sensor.imagen)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemClickListener.onItemClick(sensor)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(sensor: Sensores)
    }
}














package com.example.recetasdecomida

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterRekomendasi (val list:List<isiresep>): RecyclerView.Adapter<AdapterRekomendasi.RekomendasiViewHolder>(){

    class RekomendasiViewHolder(baris: View): RecyclerView.ViewHolder(baris){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RekomendasiViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.rekomendasimakanan,parent,false)
        return RekomendasiViewHolder(layout)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: RekomendasiViewHolder, position: Int) {
        val bind = list[position]
    }
}
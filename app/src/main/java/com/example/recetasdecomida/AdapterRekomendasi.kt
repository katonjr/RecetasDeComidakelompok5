package com.example.recetasdecomida

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class AdapterRekomendasi (val list:List<isiresep>, val fragment: FragmentManager): RecyclerView.Adapter<AdapterRekomendasi.RekomendasiViewHolder>(){

    class RekomendasiViewHolder(baris: View): RecyclerView.ViewHolder(baris){
        val layout = baris.findViewById<ConstraintLayout>(R.id.rekom)
        val gambarmakanan2 = baris.findViewById<ImageView>(R.id.gambarmakanan)
        val namamakanan2 =baris.findViewById<TextView>(R.id.namamakanan)

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



        holder.layout.setOnClickListener {
            val transaksi = fragment.beginTransaction()
            val toDetail = DetailResep()
            transaksi.replace(R.id.flFragment,toDetail)
            transaksi.commit()
        }
    }
}
package com.example.recetasdecomida.Model.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recetasdecomida.View.Fragment.DetailResepFragment
import com.example.recetasdecomida.R
import com.example.recetasdecomida.Model.ModelClass.IsiResepModel

class AdapterRekomendasi (val list:List<IsiResepModel>, val fragment: FragmentManager, val konteks: Context): RecyclerView.Adapter<AdapterRekomendasi.RekomendasiViewHolder>(){

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

        Glide.with(konteks).load(bind.gambar).placeholder(R.drawable.ic_launcher_foreground).into(holder.gambarmakanan2)

        holder.namamakanan2.text = bind.namaMakanan



        holder.layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("gambar",bind.gambar)
            bundle.putString("deskripsi",bind.deskripsi)
            bundle.putString("nama",bind.namaMakanan)
            val transaksi = fragment.beginTransaction()
            val toDetail = DetailResepFragment()
            toDetail.arguments = bundle
            transaksi.replace(R.id.flFragment,toDetail)
            transaksi.addToBackStack(null)
            transaksi.commit()
        }
    }
}
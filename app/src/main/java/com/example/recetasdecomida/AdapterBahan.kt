package com.example.recetasdecomida

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterBahan (val bahan:List<DataBahan>, val konteks: Context): RecyclerView.Adapter<AdapterBahan.BahanViewHolder>(){
    class BahanViewHolder(baris: View): RecyclerView.ViewHolder(baris){

        val gambarbahan= baris.findViewById<ImageView>(R.id.bahan1)
        val teksbahan= baris.findViewById<TextView>(R.id.teksbahan1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BahanViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.bahanmasakan,parent,false)
        return BahanViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return bahan.size
    }

    override fun onBindViewHolder(holder: BahanViewHolder, position: Int) {
       val bind= bahan[position]

        holder.teksbahan.text = bind.Bahan[0]
        Glide.with(konteks).load(bind.gambar).placeholder(R.drawable.ic_launcher_foreground).into(holder.gambarbahan)

    }
}
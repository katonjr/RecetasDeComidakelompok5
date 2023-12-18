package com.example.recetasdecomida.Model.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recetasdecomida.Model.ModelClass.ResepSimpanModel
import com.example.recetasdecomida.R

class AdapterResepTersimpan(val list: List<ResepSimpanModel>,val konteks: Context): RecyclerView.Adapter<AdapterResepTersimpan.ResepTersimpanViewHolder>() {

    class ResepTersimpanViewHolder(baris: View):RecyclerView.ViewHolder(baris){
        val tvNamaMasakan = baris.findViewById<TextView>(R.id.tvJudulResepMasakan)
        val gambar  = baris.findViewById<ImageView>(R.id.ivGambarResepSimpan)
        val btnDelete = baris.findViewById<Button>(R.id.btnDeleteResepMasakan)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepTersimpanViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.resep_simpan_layout,parent,false)
        return ResepTersimpanViewHolder(layout)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ResepTersimpanViewHolder, position: Int) {
        val bind  = list[position]

        holder.tvNamaMasakan.text = bind.namaMakanan
        Glide.with(konteks).load(bind.gambar).placeholder(R.drawable.ic_launcher_foreground).into(holder.gambar)

        holder.btnDelete.setOnClickListener {

        }
    }
}
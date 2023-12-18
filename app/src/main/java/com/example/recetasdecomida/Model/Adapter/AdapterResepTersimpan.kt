package com.example.recetasdecomida.Model.Adapter

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recetasdecomida.Model.ModelClass.ResepSimpanModel
import com.example.recetasdecomida.R
import com.example.recetasdecomida.View.Fragment.DetailResepFragment
import com.google.firebase.firestore.FirebaseFirestore

class AdapterResepTersimpan(val list: MutableList<ResepSimpanModel>,val konteks: Context,val database: FirebaseFirestore,val fragment: FragmentManager): RecyclerView.Adapter<AdapterResepTersimpan.ResepTersimpanViewHolder>() {

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
            val dialog = AlertDialog.Builder(konteks)
            dialog.setTitle("Konfirmasi")
            dialog.setMessage("Apakah Anda Yakin Ingin Menghapus Menu Ini")
            dialog.setPositiveButton("hapus"){dialog,which ->
                database.collection("resep").document(bind.id).delete()
                list.removeAt(position)
                notifyDataSetChanged()
            }
            dialog.setNegativeButton("Batal"){dialog,which ->
                dialog.dismiss()
            }
            dialog.show()
        }

        holder.gambar.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("nama",bind.namaMakanan)
            bundle.putString("deskripsi",bind.deskripsi)
            bundle.putString("gambar",bind.gambar)
            val toDetail = DetailResepFragment()
            toDetail.arguments = bundle
            val transaksi = fragment.beginTransaction()
            transaksi.replace(R.id.flFragment,toDetail)
            transaksi.addToBackStack(null)
            transaksi.commit()
        }


    }
}
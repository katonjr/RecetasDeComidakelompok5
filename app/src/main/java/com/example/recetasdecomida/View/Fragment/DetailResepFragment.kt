package com.example.recetasdecomida.View.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.recetasdecomida.R
import com.google.firebase.firestore.FirebaseFirestore

class DetailResepFragment : Fragment() {
    private lateinit var tvNamaMasakan:TextView
    private lateinit var tvDeskripsi: TextView
    private lateinit var gambarMakanan: ImageView
    private lateinit var btnSimpan: Button
    private lateinit var firestore: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val buttonLink : Button
        val myview = inflater.inflate(R.layout.fragment_detail_resep, container, false)
        // Inflate the layout for this fragment
        buttonLink = myview.findViewById(R.id.btn_link)
        buttonLink.setOnClickListener {
            val uris = Uri.parse("https://www.youtube.com/watch?v=0-Dp4fXAPAg")
            val intents = Intent(Intent.ACTION_VIEW, uris)
            requireContext().startActivity(intents)
        }
        return myview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvDeskripsi = view.findViewById(R.id.tvDeskripsiMakanan)
        tvNamaMasakan = view.findViewById(R.id.tvNamaMakananDetail)
        gambarMakanan = view.findViewById(R.id.ivGambarDetailResep)
        btnSimpan = view.findViewById(R.id.buttonsimpanDetail)
        firestore = FirebaseFirestore.getInstance()

        val gambar = arguments?.getString("gambar")
        val namaMakanan = arguments?.getString("nama")
        val deskripsi  = arguments?.getString("deskripsi")


        tvNamaMasakan.text = namaMakanan
        tvDeskripsi.text = deskripsi
        Glide.with(requireContext()).load(gambar).placeholder(R.drawable.ic_launcher_foreground).into(gambarMakanan)

        btnSimpan.setOnClickListener {
            addDataToFirestore(namaMakanan!!,gambar!!,deskripsi!!)
        }

    }
    fun addDataToFirestore(namaMasakan: String,gambar: String,deskripsi: String){
        val dataku = hashMapOf(
            "nama" to namaMasakan,
            "gambar" to gambar,
            "deskripsi" to deskripsi
        )
        firestore.collection("resep").add(dataku).addOnSuccessListener {
            Toast.makeText(requireContext(), "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Gagal Menambahkan Data ${it}", Toast.LENGTH_SHORT).show()
        }

    }
}

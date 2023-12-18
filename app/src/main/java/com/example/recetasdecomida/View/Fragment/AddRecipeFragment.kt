package com.example.recetasdecomida.View.Fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.recetasdecomida.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage


class AddRecipeFragment : Fragment() {
    private lateinit var etNamaResep: EditText
    private lateinit var etDeskripsiResep: EditText
    private lateinit var etBahanResep: EditText
    private lateinit var btnSimpanResep: Button
    private lateinit var btnAddFoto: ImageView
    private lateinit var tvTemp : TextView
    private lateinit var firestore: FirebaseFirestore
    private lateinit var penyimpanan: FirebaseStorage
    private lateinit var progress : ProgressBar
    private lateinit var url: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etBahanResep = view.findViewById(R.id.etBahanResep)
        etDeskripsiResep = view.findViewById(R.id.etDeskripsiResep)
        etNamaResep = view.findViewById(R.id.etNamaResep)
        btnSimpanResep  = view.findViewById(R.id.btnAddRecipe)
        tvTemp = view.findViewById(R.id.tvTempVuew)
        btnAddFoto = view.findViewById(R.id.ivMasukkanGambar)
        progress = view.findViewById(R.id.progressBarUpload)
        firestore = FirebaseFirestore.getInstance()
        penyimpanan = FirebaseStorage.getInstance()
        progress.visibility = View.GONE
        val galleryImage = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                btnAddFoto.setImageURI(it)
                url = it!!
            }
        )

        btnAddFoto.setOnClickListener {
           galleryImage.launch("image/*")
            tvTemp.visibility = View.GONE

        }

        btnSimpanResep.setOnClickListener {
            progress.visibility = View.VISIBLE
            penyimpanan.getReference("images").child(System.currentTimeMillis().toString())
                .putFile(url)
                .addOnSuccessListener { urlgambar ->
                    urlgambar.metadata!!.reference!!.downloadUrl
                        .addOnSuccessListener {

                            val bahanHasil = etBahanResep.text.toString()
                            val namaHasil = etNamaResep.text.toString()
                            val deskripsiHasil = etDeskripsiResep.text.toString()

                            val mappinngData = hashMapOf(
                                "nama" to namaHasil,
                                "bahan" to bahanHasil,
                                "deskripsi" to deskripsiHasil,
                                "gambar" to  it
                            )

                            firestore.collection("masakan").add(mappinngData).addOnSuccessListener {
                                progress.visibility = View.GONE
                                Toast.makeText(requireContext(), "Tambah Data Berhasil", Toast.LENGTH_SHORT).show()
                            }.addOnFailureListener {
                                Toast.makeText(requireContext(), "Tambah Data Gagal", Toast.LENGTH_SHORT).show()
                            }

                        }
                }
        }


    }
}
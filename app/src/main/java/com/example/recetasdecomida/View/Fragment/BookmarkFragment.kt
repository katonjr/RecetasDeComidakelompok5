package com.example.recetasdecomida.View.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recetasdecomida.Model.Adapter.AdapterResepTersimpan
import com.example.recetasdecomida.Model.ModelClass.ResepSimpanModel
import com.example.recetasdecomida.R
import com.example.recetasdecomida.ViewModel.ResepSimpanViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class BookmarkFragment : Fragment() {
    private lateinit var recylerResepSimpan: RecyclerView
    private lateinit var firestore: FirebaseFirestore
    private val resepViewModel: ResepSimpanViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recylerResepSimpan = view.findViewById(R.id.recylerResepDisimpan)
        firestore = FirebaseFirestore.getInstance()

        GlobalScope.launch { getDataResepMasakan() }

        resepViewModel.getListResep.observe(viewLifecycleOwner){newValue ->
            recylerResepSimpan.layoutManager = LinearLayoutManager(requireContext())
            recylerResepSimpan.adapter = AdapterResepTersimpan(newValue,requireContext())
        }

    }

    suspend fun getDataResepMasakan(){
        val data  = firestore.collection("resep").get().await()
        withContext(Dispatchers.IO){
            data?.let {document ->
                val listResepSimpan = document.map { doc ->
                    ResepSimpanModel(
                        doc.id,
                        doc.getString("nama")?:"",
                        doc.getString("gambar")?:"",
                        doc.getString("deskripsi")?:""
                    )
                }

                resepViewModel._listResep.postValue(listResepSimpan)


            }
        }
    }
}
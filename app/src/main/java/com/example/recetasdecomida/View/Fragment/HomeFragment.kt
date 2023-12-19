package com.example.recetasdecomida.View.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recetasdecomida.Model.Adapter.AdapterBahan
import com.example.recetasdecomida.Model.Adapter.AdapterRekomendasi
import com.example.recetasdecomida.Model.ModelClass.IsiResepModel
import com.example.recetasdecomida.R
import com.example.recetasdecomida.ViewModel.HomeViewModel
import com.example.recetasdecomida.listBahan
import com.example.recetasdecomida.listRekomendasi
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    private lateinit var recylerrekomendasi: RecyclerView
    private lateinit var recyclerbahan: RecyclerView
    private lateinit var firestore: FirebaseFirestore
    private val homeViewModel: HomeViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recylerrekomendasi = view.findViewById(R.id.listrekomendasi)
        recyclerbahan = view.findViewById(R.id.bahanmasakan)
        firestore = FirebaseFirestore.getInstance()

        GlobalScope.launch { getDataRekomendasi() }

        homeViewModel.getListRekomendasi.observe(viewLifecycleOwner){newValue ->
            recylerrekomendasi.layoutManager = LinearLayoutManager(requireContext())
            recylerrekomendasi.adapter = AdapterRekomendasi(newValue,requireActivity().supportFragmentManager,requireContext())
        }

        recyclerbahan.layoutManager= GridLayoutManager(requireContext(),4)
        recyclerbahan.adapter = AdapterBahan(listBahan,requireContext())
    }

    suspend fun getDataRekomendasi(){
        val data = firestore.collection("masakan").get().await()
        withContext(Dispatchers.IO){
            data?.let { document ->
                val listRekomendasi = document.map { doc ->
                    IsiResepModel(
                        doc.getString("gambar")?:"",
                        doc.getString("nama")?:"",
                        doc.getString("deskripsi")?:"",
                        doc.getString("bahan")?:""
                    )
                }
                homeViewModel._listRekomendasi.postValue(listRekomendasi)
            }
        }
    }

}
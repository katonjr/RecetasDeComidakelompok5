package com.example.recetasdecomida.View.Fragment

import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recetasdecomida.Model.Adapter.AdapterResepTersimpan
import com.example.recetasdecomida.Model.ModelClass.ResepSimpanModel
import com.example.recetasdecomida.R
import com.example.recetasdecomida.ViewModel.SearchingViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class SearchFragment : Fragment() {
    private lateinit var recyletSearching: RecyclerView
    private lateinit var firestore: FirebaseFirestore
    private lateinit var etSearching: EditText
    private lateinit var btnSearch : Button
    private val searchViewModel: SearchingViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyletSearching = view.findViewById(R.id.recylerSearching)
        firestore = FirebaseFirestore.getInstance()
        etSearching = view.findViewById(R.id.etNamaResepSearch)
        btnSearch = view.findViewById(R.id.btnSearchResepMasakan)



        GlobalScope.launch { getDataToFirestore() }

        searchViewModel.getListSearching.observe(viewLifecycleOwner){newValue ->
            recyletSearching.layoutManager = LinearLayoutManager(requireContext())
            recyletSearching.adapter = AdapterResepTersimpan(newValue.toMutableList(),requireContext(),firestore,requireActivity().supportFragmentManager)
        }

        btnSearch.setOnClickListener {
            searchViewModel.setText(etSearching.text.toString())
            if (searchViewModel.getSearchText.value == ""){
                GlobalScope.launch { getDataToFirestore() }
            }else{
                GlobalScope.launch { getFilterData(searchViewModel.getSearchText.value!!)
            }
             }
        }




    }

    suspend fun getDataToFirestore(){
        val data  = firestore.collection("masakan").get().await()
        withContext(Dispatchers.IO){
            data?.let { document ->
                val listMakanan = document.map { doc ->
                    ResepSimpanModel(
                        doc.id,
                        doc.getString("nama")?:"",
                        doc.getString("gambar")?:"",
                        doc.getString("deskripsi")?:""
                    )
                }

                searchViewModel.listSearching.postValue(listMakanan)

            }
        }
    }

    suspend fun getFilterData(namaResep: String){
        val database = firestore.collection("masakan").whereEqualTo("nama",namaResep).get().await()
        withContext(Dispatchers.IO){
            database?.let { document ->
                val listFilter = document.map { doc ->
                    ResepSimpanModel(
                        doc.id,
                        doc.getString("nama")?:"",
                        doc.getString("gambar")?:"",
                        doc.getString("deskripsi")?:""
                    )
                }
                searchViewModel.listSearching.postValue(listFilter)
            }
        }
    }
}
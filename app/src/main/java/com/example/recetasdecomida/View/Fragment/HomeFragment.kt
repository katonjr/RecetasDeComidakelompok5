package com.example.recetasdecomida.View.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recetasdecomida.Model.Adapter.AdapterBahan
import com.example.recetasdecomida.Model.Adapter.AdapterRekomendasi
import com.example.recetasdecomida.R
import com.example.recetasdecomida.listBahan
import com.example.recetasdecomida.listRekomendasi

class HomeFragment : Fragment() {
    private lateinit var recylerrekomendasi: RecyclerView
    private lateinit var recyclerbahan: RecyclerView


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

        recylerrekomendasi.layoutManager = LinearLayoutManager(requireContext())
        recylerrekomendasi.adapter = AdapterRekomendasi(listRekomendasi,requireActivity().supportFragmentManager,requireContext())
        recyclerbahan.layoutManager= GridLayoutManager(requireContext(),4)
        recyclerbahan.adapter = AdapterBahan(listBahan,requireContext())
    }
}
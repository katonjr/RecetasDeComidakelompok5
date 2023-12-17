package com.example.recetasdecomida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        recylerrekomendasi.adapter = AdapterRekomendasi(listRekomendasi)
        recyclerbahan.layoutManager= GridLayoutManager(requireContext(),4)
        recyclerbahan.adapter = AdapterBahan(listBahan)
    }
}
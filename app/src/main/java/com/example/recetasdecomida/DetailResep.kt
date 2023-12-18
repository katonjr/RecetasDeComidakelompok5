package com.example.recetasdecomida

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class DetailResep : Fragment() {


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
}

package com.example.recetasdecomida

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


class AccountFragment : Fragment() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var firebaseApp: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.buttonlogout)
        textView = view.findViewById(R.id.emailuser)
        firebaseApp = FirebaseAuth.getInstance()
        textView.text = firebaseApp.currentUser!!.email
        button.setOnClickListener {
            firebaseApp.signOut()
            val keluar = Intent(requireContext(),login :: class.java)
            startActivity(keluar)
            requireActivity().finish()
        }

    }
}
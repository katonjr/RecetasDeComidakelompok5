package com.example.recetasdecomida

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            onNavigationItemSelected(item)
        }
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.home)
        }
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        val selectedFragment: Fragment = when (item.itemId) {
            R.id.home -> HomeFragment()
            R.id.bookmark -> BookmarkFragment()
            R.id.search -> SearchFragment()
            R.id.addrecipe -> AddRecipeFragment()
            R.id.account -> AccountFragment()
            else -> HomeFragment() // Default fragment, bisa diubah sesuai kebutuhan
        }

        return loadFragment(selectedFragment)
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
        return true
    }
}

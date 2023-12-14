package com.example.recetasdecomida

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            onNavigationItemSelected(
                item
            )
        })
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.home)
        }
    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.home -> selectedFragment = HomeFragment()
            R.id.bookmark -> selectedFragment = BookmarkFragment()
            R.id.search -> selectedFragment = SearchFragment()
            R.id.addrecipe -> selectedFragment = AddRecipeFragment()
            R.id.account -> selectedFragment = AccountFragment()
        }
        if (selectedFragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.flFragment, selectedFragment)
            transaction.commit()
        }
        return true
    }
}
package com.example.intaka

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_add -> {
                loadFragment(AddFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_feather -> {
                loadFragment(FeatherFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_location -> {
                loadFragment(LocationFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_person -> {
                loadFragment(PersonFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                loadFragment(SettingsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        loadFragment(AddFragment()) // Load the initial fragment.
    }
}

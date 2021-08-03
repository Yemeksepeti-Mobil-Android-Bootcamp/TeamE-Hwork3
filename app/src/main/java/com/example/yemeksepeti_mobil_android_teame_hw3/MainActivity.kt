package com.example.yemeksepeti_mobil_android_teame_hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fragmentHome: HomeFragment = HomeFragment()
        val bottomNavView : BottomNavigationView = findViewById(R.id.bottom_nav_view)

        setCurrentFragment(fragmentHome)

        bottomNavView?.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.explore -> setCurrentFragment(fragmentHome)
                R.id.trips -> setCurrentFragment(fragmentHome)
                R.id.saved -> setCurrentFragment(fragmentHome)
                R.id.profile-> setCurrentFragment(fragmentHome)
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }
}



package com.example.yemeksepeti_mobil_android_teame_hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog.CatalogFragment
import com.example.yemeksepeti_mobil_android_teame_hw3.ui.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_home)
        //setSupportActionBar(toolbar)

        val fragmentHome: HomeFragment = HomeFragment()
        val fragmentCatalog: CatalogFragment = CatalogFragment()
        val fragmentProfile: ProfileFragment = ProfileFragment()
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_view)


        val navController = findNavController(R.id.fragment)
        bottomNavView.setupWithNavController(navController)

        /*setCurrentFragment(fragmentHome)

        bottomNavView?.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.explore -> setCurrentFragment(fragmentHome)
                R.id.trips -> setCurrentFragment(fragmentCatalog)
                R.id.saved -> setCurrentFragment(fragmentHome)
                R.id.profile-> setCurrentFragment(fragmentProfile)
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }*/
    }
}



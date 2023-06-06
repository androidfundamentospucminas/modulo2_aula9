package com.walker.aula9modulo2androidfundamentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.walker.aula9modulo2androidfundamentos.fragments.FeedFragment
import com.walker.aula9modulo2androidfundamentos.fragments.HomeFragment
import com.walker.aula9modulo2androidfundamentos.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                }
                R.id.navigation_dashboard -> {
                    replaceFragment(FeedFragment())

                }
                R.id.navigation_profile -> {
                    replaceFragment(ProfileFragment())
                }
                else -> false
            }
        }

        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
        return true
    }
}
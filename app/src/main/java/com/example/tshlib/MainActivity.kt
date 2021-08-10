package com.example.tshlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val dashboardFragment : Fragment = DashboardFragment()
        val learnFragment : Fragment = LearnFragment()
        val profileFragment : Fragment = ProfileFragment()
        var currentFragment: Fragment = dashboardFragment
        if(intent.hasExtra("startingFragment")) {
            when(intent.getStringExtra("startingFragment")) {
                "learn" -> currentFragment = learnFragment
                "profile" -> currentFragment = profileFragment

            }
        }

        setCurrentFragment(currentFragment)

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_dashboard->setCurrentFragment(dashboardFragment)
                R.id.nav_learn->setCurrentFragment(learnFragment)
                R.id.nav_profile->setCurrentFragment(profileFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            addToBackStack(null)
            commit()
        }
    }

}
package com.example.tshlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_dashboard.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigation)
        val dashboardFragment : Fragment = DashboardFragment()
        val learnFragment : Fragment = LearnFragment()
        val profileFragment : Fragment = ProfileFragment()
        val quizFragment : Fragment = QuizFragment()


        setCurrentFragment(dashboardFragment)

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_dashboard->setCurrentFragment(quizFragment)
                R.id.nav_learn->setCurrentFragment(learnFragment)
                R.id.nav_profile->setCurrentFragment(profileFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFragment, fragment)
            addToBackStack(null)
            commit()
        }
    }

}
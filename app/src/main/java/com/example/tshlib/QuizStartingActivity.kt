package com.example.tshlib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class QuizStartingActivity : AppCompatActivity() {
    lateinit var currentFragment: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_starting)


        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_dashboard->currentFragment = "dashboard"
                R.id.nav_learn->currentFragment = "learn"
                R.id.nav_profile->currentFragment = "profile"
            }
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("startingFragment", currentFragment)
            startActivity(intent)
            true
        }


    }


}
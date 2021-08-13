package com.example.tshlib

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_quiz_section.view.*
import kotlinx.android.synthetic.main.activity_quiz.*
import com.google.android.material.bottomnavigation.BottomNavigationView


public class Global : Application() {
    companion object {
        var score: Int = 0
    }
}

class QuizActivity : AppCompatActivity() {
    lateinit var currentFragment: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val sectionTitles: MutableList<String> = mutableListOf("Waste", "Food", "Transportion", "Energy")
        val q1: List<Int> = listOf(R.string.qWaste1,R.string.qFood1,R.string.qEnergy1,R.string.qTransportation1)
        val q2: List<Int> = listOf(R.string.qWaste2,R.string.qFood2,R.string.qTransportation2,R.string.qEnergy2)


        val sectionAdapter = QuizPagerAdapter(q1,q2)
        quiz_viewpager.adapter = sectionAdapter

        TabLayoutMediator(tab, quiz_viewpager) { tab, position ->
            tab.setText(sectionTitles[position])
        }.attach()

        setContentView(R.layout.fragment_quiz_section)
        val submitBtn : Button = findViewById(R.id.submit)
        submitBtn.setOnClickListener{
            val intent = Intent(this, QuizResults::class.java)
            startActivity(intent)
        }

        setContentView(R.layout.activity_main)
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
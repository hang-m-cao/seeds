package com.example.tshlib

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_quiz_results.*

class QuizResultActivity : AppCompatActivity() {
    lateinit var currentFragment: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_results)

        val lrnBtn : Button = findViewById(R.id.lrn_button)
        lrnBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("startingFragment", "learn")
            startActivity(intent)
        }

        val sharedPreferences = getSharedPreferences("user_score", Context.MODE_PRIVATE)
        val score = sharedPreferences.getInt("score",0)
        score_result.text = "${getString(R.string.score)} $score"

        if (score < 10) {
            quiz_result_message.text = "${getString(R.string.level_congrats)} Sapling"
        } else if (score < 20) {
            avatar.setImageResource(R.drawable.cactus2)
            quiz_result_message.text = "${getString(R.string.level_congrats)} Mother Tree"
        } else {
            avatar.setImageResource(R.drawable.cactus)
            quiz_result_message.text = "${getString(R.string.level_congrats)} God"
        }

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
package com.example.tshlib

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quiz.*

public class Global : Application() {
    companion object {
        var score: Int = 0
    }
}

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val sectionTitles: MutableList<String> = mutableListOf("Waste", "Food", "Energy", "Transportion")
        val q1: List<Int> = listOf(R.string.qWaste1,R.string.qFood1,R.string.qEnergy1,R.string.qTransportation1)
        val q2: List<Int> = listOf(R.string.qWaste2,R.string.qFood2,R.string.qEnergy2,R.string.qTransportation2)


        val sectionAdapter = QuizPagerAdapter(q1,q2)
        quiz_viewpager.adapter = sectionAdapter

        setContentView(R.layout.activity_quiz)



        TabLayoutMediator(tab, quiz_viewpager) { tab, position ->
            tab.setText(sectionTitles[position])
        }.attach()



    }

}
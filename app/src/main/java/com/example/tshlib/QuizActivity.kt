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
        val dummyQuestions: MutableList<MutableList<Question>> = mutableListOf()

        for (i in 1..4) {
            dummyQuestions.add(generateDummyQuestions())
        }

        val sectionAdapter = QuizPagerAdapter(dummyQuestions,q1,q2)
        quiz_viewpager.adapter = sectionAdapter

        setContentView(R.layout.activity_quiz)

        val opt1 : Button = findViewById(R.id.option1)
        opt1.setOnClickListener{
            Global.score = Global.score+1
        }
        val opt2 : Button = findViewById(R.id.option2)
        opt2.setOnClickListener{
            Global.score = Global.score+1
        }
        val opt3 : Button = findViewById(R.id.option3)
        opt3.setOnClickListener{
            Global.score = Global.score+1
        }
        val opt4 : Button = findViewById(R.id.option4)
        opt4.setOnClickListener{
            Global.score = Global.score + 1
        }

        TabLayoutMediator(tab, quiz_viewpager) { tab, position ->
            tab.setText(sectionTitles[position])
        }.attach()



    }
    private fun generateDummyQuestions(): MutableList<Question> {
        val result = mutableListOf<Question>()

        for (i in 1..3) {
            result.add(
                Question(title = "Question $i", option1 = "", option2 = "", option3 = "", option4 = ""
                )
            )
        }
        return result
    }
}
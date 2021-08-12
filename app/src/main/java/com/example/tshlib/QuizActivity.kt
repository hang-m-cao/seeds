package com.example.tshlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val sectionTitles: MutableList<String> =
            mutableListOf("Waste", "Food", "Energy", "Pollution")
        val dummyQuestions: MutableList<MutableList<Question>> = mutableListOf()

        for (i in 1..4) {
            dummyQuestions.add(generateDummyQuestions())
        }

        val sectionAdapter = QuizPagerAdapter(dummyQuestions)
        quiz_viewpager.adapter = sectionAdapter

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
package com.example.tshlib

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_learn.*
import kotlinx.android.synthetic.main.fragment_quiz.*

class QuizFragment: Fragment(R.layout.fragment_quiz) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionTitles: MutableList<String> =
            mutableListOf("Waste", "Food", "Energy", "Pollution")
        val dummyQuestions: MutableList<MutableList<Question>> = mutableListOf()

        for (i in 1..4) {
            dummyQuestions.add(generateDummyQuestions())
        }

        val sectionAdapter = QuizPagerAdapter(dummyQuestions)
        quiz_viewpager.adapter = sectionAdapter

        TabLayoutMediator(sectionTabs, quiz_viewpager) { tab, position ->
            tab.setText(sectionTitles[position])
        }.attach()

    }

    private fun generateDummyQuestions(): MutableList<Question> {
        val result = mutableListOf<Question>()

        for (i in 1..3) {
            result.add(
                Question(
                    title = "Question $i",
                    option1 = "",
                    option2 = "",
                    option3 = "",
                    option4 = ""
                )
            )
        }
        return result
    }
}
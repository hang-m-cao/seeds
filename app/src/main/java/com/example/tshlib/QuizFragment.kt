package com.example.tshlib

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_learn.*

class QuizFragment: Fragment(R.layout.fragment_quiz) {

    private lateinit var quizAdapter: QuizAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionTitles: MutableList<String> = mutableListOf("Featured", "Waste", "Food", "Energy", "Pollution")
        val dummyQuestions: MutableList<Questions> = mutableListOf()

        for(i in 1..3) {
            dummyQuestions.add(Question("article $i", null))
        }

        val sections: MutableList<QuizSection> = mutableListOf()

        for(i in 0 until sectionTitles.size) {
            sections.add(QuizSection(sectionTitles[i], dummyArticles))
        }

        quizAdapter = LearnAdapter(sections)
        rv_quiz_sections.adapter = learnAdapter
        rv_quiz_sections.layoutManager = LinearLayoutManager(context)

    }
}
package com.example.tshlib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_learn.*

class LearnFragment: Fragment(R.layout.fragment_learn) {

    private lateinit var learnAdapter: LearnAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionTitles: MutableList<String> = mutableListOf("Featured", "Category 1", "Category 2", "Category 3")
        val dummyArticles: MutableList<Article> = mutableListOf()

        for(i in 1..3) {
            dummyArticles.add(Article("title", i.toString()))
        }
        val sections: MutableList<LearnSection> = mutableListOf()

        for(i in 0 until sectionTitles.size) {
            sections.add(LearnSection(sectionTitles[i], dummyArticles))
        }

        learnAdapter = LearnAdapter(sections)
        rv_articles.adapter = learnAdapter
        rv_articles.layoutManager = LinearLayoutManager(context)

    }
}
package com.example.tshlib

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_learn.*

class LearnFragment: Fragment(R.layout.fragment_learn) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionTitles: List<Int> = listOf(R.string.section1, R.string.section2, R.string.section3, R.string.section4)

        val dummyArticles: MutableList<Article> = mutableListOf()

        for(i in 1..7) {
            dummyArticles.add(Article("$i Step(s) to Sustainable Eating"))
        }

        val sectionAdapter = PagerAdapter(requireContext(), sectionTitles, dummyArticles)
        viewPagerSections.adapter = sectionAdapter

        TabLayoutMediator(section_tabs, viewPagerSections) { tab, position ->
            tab.setText(sectionTitles[position])
        }.attach()

    }
}
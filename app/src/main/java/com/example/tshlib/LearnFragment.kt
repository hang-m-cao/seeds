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
        val quickTips: List<Int> = listOf(R.string.q_t_waste, R.string.q_t_food, R.string.q_t_transport, R.string.q_t_energy)

        val dummyArticles: MutableList<MutableList<Article>> = mutableListOf()

        for(stringId in sectionTitles) {
            dummyArticles.add(generateDummyArticles(getString(stringId)))
        }

        val sectionAdapter = PagerAdapter(dummyArticles, quickTips)
        learn_viewpager_sections.adapter = sectionAdapter

        TabLayoutMediator(learn_section_tabs, learn_viewpager_sections) { tab, position ->
            tab.setText(sectionTitles[position])
        }.attach()

    }

    private fun generateDummyArticles(sectionTitle: String): MutableList<Article> {
        val result = mutableListOf<Article>()

        for (i in 1..sectionTitle.length) {
            result.add(Article(0,"Article $i in $sectionTitle", link = "", tag = sectionTitle, image = null))

        }

        return result
    }
}
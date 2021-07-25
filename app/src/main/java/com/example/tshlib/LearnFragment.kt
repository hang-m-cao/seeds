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

        val dummyArticles: MutableList<MutableList<Article>> = mutableListOf()

        for(stringId in sectionTitles) {
            dummyArticles.add(generateDummyArticles(getString(stringId)))
        }

        val sectionAdapter = PagerAdapter(sectionTitles, dummyArticles)
        viewPagerSections.adapter = sectionAdapter

        TabLayoutMediator(sectionTabs, viewPagerSections) { tab, position ->
            tab.setText(sectionTitles[position])
        }.attach()

    }

    private fun generateDummyArticles(sectionTitle: String): MutableList<Article> {
        val result = mutableListOf<Article>()

        for (i in 1..sectionTitle.length) {
            result.add(Article("Article $i in $sectionTitle"))
        }

        return result
    }
}
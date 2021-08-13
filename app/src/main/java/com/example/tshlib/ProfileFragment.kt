package com.example.tshlib

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dummyArticles = mutableListOf<Article>()
        dummyArticles.add(Article(0, "5 Steps to Sustainable Eating", "", "", "Food"))
        dummyArticles.add(Article(0, "Drive Less, Eat More", "", "", "Transport"))

        progressBar.incrementProgressBy(Global.score)
        print(Global.score)


        for (i in 1..5) {
            dummyArticles.add(Article(0, "Article $i", "", "", "Tag $i"))
        }

        my_articles_recyclerview.adapter = SavedArticlesAdapter(dummyArticles)
        my_articles_recyclerview.layoutManager = LinearLayoutManager(context)
    }
}
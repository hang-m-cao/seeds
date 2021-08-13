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

        progressBar.incrementProgressBy(Global.score)
        print(Global.score)
        
        var db = context?.let { SavedArticlesDB.getInstance(it).articleDAO() }
        var dummyArticles = mutableListOf<Article>()
        if (db != null) {
            dummyArticles = db.getArticles().toMutableList()
        }

        my_articles_recyclerview.adapter = SavedArticlesAdapter(dummyArticles)
        my_articles_recyclerview.layoutManager = LinearLayoutManager(context)

    }
}
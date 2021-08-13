package com.example.tshlib

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sharedPreferences = context?.getSharedPreferences("user_score", Context.MODE_PRIVATE)
        var score: Int = 0
        if (sharedPreferences != null) {
            score = sharedPreferences.getInt("score",0)
            Log.d("saved_score", score.toString())
        }
        progressBar.incrementProgressBy(score)
        Log.d("score", score.toString())
        
        var db = context?.let { SavedArticlesDB.getInstance(it).articleDAO() }
        var dummyArticles = mutableListOf<Article>()
        if (db != null) {
            dummyArticles = db.getArticles().toMutableList()
        }

        my_articles_recyclerview.adapter = SavedArticlesAdapter(dummyArticles)
        my_articles_recyclerview.layoutManager = LinearLayoutManager(context)

    }
}
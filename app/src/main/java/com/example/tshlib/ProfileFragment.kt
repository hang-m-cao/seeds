package com.example.tshlib

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = context?.getSharedPreferences("user_score", Context.MODE_PRIVATE)
        var score = 0
        if (sharedPreferences != null) {
            score = sharedPreferences.getInt("score",0)
            Log.d("saved_score", score.toString())
        }
        progressBar.incrementProgressBy(score)
        Log.d("score", score.toString())

        val scoreMod10 = score%10
        val nextLevelPoints = 10 - scoreMod10
        points_to.text = "$nextLevelPoints ${getString(R.string.progress_points)}"
        var levelText = getString(R.string.sapling)

        if (score in 10..19) {
            level_image.setImageResource(R.drawable.cactus2)
            progressBar.progress = scoreMod10
            levelText = getString(R.string.mother_tree)
        } else if (score > 10) {
            level_image.setImageResource(R.drawable.cactus)
            progressBar.progress = scoreMod10
            levelText = getString(R.string.god)
        }

        level.text = "${getString(R.string.your_level)} $levelText"
        val db = context?.let { SavedArticlesDB.getInstance(it).articleDAO() }
        var savedArticles = mutableListOf<Article>()
        if (db != null) {
            savedArticles = db.getArticles().toMutableList()
        }

        my_articles_recyclerview.adapter = SavedArticlesAdapter(savedArticles)
        my_articles_recyclerview.layoutManager = LinearLayoutManager(context)

    }
}
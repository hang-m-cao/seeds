package com.example.tshlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_article_view.*


class ArticleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_view)

        done_button.setOnClickListener {
            onBackPressed()
        }

        if (intent.hasExtra("link")) {
            val link = intent.getStringExtra("link")
            if (link != null) {
                article_view.loadUrl(link)
            }
        }

    }

    override fun onBackPressed() {
        if (article_view.canGoBack()) {
            article_view.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
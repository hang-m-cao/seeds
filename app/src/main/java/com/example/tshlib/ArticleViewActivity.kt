package com.example.tshlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_article_view.*


class ArticleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_view)

        done_text.setOnClickListener {
            done_text.setTextColor(resources.getColor(R.color.light_gray))
            Handler(Looper.getMainLooper()).postDelayed({
                super.onBackPressed()
            }, 50)

        }

        if (intent.hasExtra("link")) {
            val link = intent.getStringExtra("link")
            if (!link.isNullOrEmpty()) {
                article_webview.loadUrl(link)
            }
        }

    }

    override fun onBackPressed() {
        if (article_webview.canGoBack()) {
            article_webview.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
package com.example.tshlib

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_article_view.*


class ArticleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_view)

        val articleWebView: WebView = findViewById(R.id.article_webview)
        val progressBar: ProgressBar = findViewById(R.id.progress_bar)
        articleWebView.webViewClient = ArticleWebClient(progressBar)
        articleWebView.settings.javaScriptEnabled = true

        done_text.setOnClickListener {
            done_text.setTextColor(resources.getColor(R.color.light_gray))
            Handler(Looper.getMainLooper()).postDelayed({
                super.onBackPressed()
            }, 50)
        }

        if (intent.hasExtra("link")) {
            val link = intent.getStringExtra("link")
            if (!link.isNullOrEmpty()) {
                articleWebView.loadUrl(link)
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

class ArticleWebClient(private val progressBar: ProgressBar) : WebViewClient() {
    override fun onPageFinished(view: WebView, url: String) {
        progressBar.visibility = View.GONE
        super.onPageFinished(view, url)
    }

    override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
        if (favicon != null) {
            super.onPageStarted(view, url, favicon)
        }

    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }

    override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
        view.loadUrl("file:///android_asset/error.html")
    }
}

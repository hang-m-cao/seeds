package com.example.tshlib

import android.os.Build
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_learn_sections.view.*


class PagerAdapter
    (private val articles: MutableList<MutableList<Article>>,
    private val quickTips: List<Int>):
    RecyclerView.Adapter<PagerAdapter.PageHolder>(){

    inner class PageHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        return PageHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_learn_sections, parent, false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onBindViewHolder(holder: PageHolder, position: Int) {

        val articlesAdapter = ArticlesAdapter(articles[position])

        holder.itemView.apply {
            articlesRecyclerView.adapter = articlesAdapter
            articlesRecyclerView.layoutManager = LinearLayoutManager(context)

            val text = resources.getString(quickTips[position])
            quickTipsText.text = formatQuickTipsText(text)
        }

    }

    override fun getItemCount(): Int {
        return articles.size
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun formatQuickTipsText(text: String): SpannableStringBuilder {
        val res = SpannableStringBuilder()
        val bulletPoints = text.split("\n")

        for (i in bulletPoints.indices) {
            val line = bulletPoints[i]
            val quickTip = SpannableString(line)
            quickTip.setSpan(BulletSpan(20), 0, line.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            res.append(quickTip)

            if (i < bulletPoints.size - 1) {
                res.append("\n")
            }
        }
        return res
    }
}
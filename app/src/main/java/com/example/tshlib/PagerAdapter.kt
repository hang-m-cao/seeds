package com.example.tshlib

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_learn_sections.view.*

class PagerAdapter
    (private val sectionTitles: List<Int>,
     private val articles: MutableList<MutableList<Article>>):
    RecyclerView.Adapter<PagerAdapter.PageHolder>(){

    inner class PageHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        return PageHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_learn_sections, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PageHolder, position: Int) {

        val articlesAdapter = ArticlesAdapter(articles[position])

        holder.itemView.apply {
            articlesRecyclerView.adapter = articlesAdapter
            articlesRecyclerView.layoutManager = GridLayoutManager(context, 2)

            quickTipsToggleShow.setOnClickListener {
                quickTipsToggleHide.visibility = View.VISIBLE
                quickTipsCard.visibility = View.GONE
            }

            quickTipsToggleHide.setOnClickListener{
                quickTipsToggleHide.visibility = View.INVISIBLE
                quickTipsCard.visibility = View.VISIBLE
            }
        }

    }

    override fun getItemCount(): Int {
        return articles.size
    }
}
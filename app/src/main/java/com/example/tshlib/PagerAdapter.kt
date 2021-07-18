package com.example.tshlib

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_learn_sections.view.*

class PagerAdapter
    (private val context: Context,
     private val sectionTitles: List<Int>,
     private val articles: MutableList<Article>):
    RecyclerView.Adapter<PagerAdapter.PageHolder>(){

    inner class PageHolder(view: View): RecyclerView.ViewHolder(view){
        val sectionTitle: TextView = view.tv_sectionTitle
        val articlesRecyclerView: RecyclerView = view.rv_articles
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        return PageHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_learn_sections, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        holder.sectionTitle.setText(sectionTitles[position])
        val articlesAdapter = ArticlesAdapter(articles)
        holder.articlesRecyclerView.adapter = articlesAdapter
        holder.articlesRecyclerView.layoutManager = GridLayoutManager(context, 2)
    }

    override fun getItemCount(): Int {
        return sectionTitles.size
    }
}
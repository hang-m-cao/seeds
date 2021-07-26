package com.example.tshlib

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_learn_sections.view.*

class PagerAdapter
    (private val articles: MutableList<MutableList<Article>>):
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
            articlesRecyclerView.layoutManager = LinearLayoutManager(context)

        }

    }

    override fun getItemCount(): Int {
        return articles.size
    }
}
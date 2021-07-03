package com.example.tshlib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_learn_sections.view.*

class LearnAdapter(private val sections: MutableList<LearnSection>):
        RecyclerView.Adapter<LearnAdapter.LearnViewHolder>() {

    class LearnViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnViewHolder {
        return LearnViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_learn_sections, parent, false))
    }

    override fun getItemCount(): Int {
        return sections.size
    }

    override fun onBindViewHolder(holder: LearnViewHolder, position: Int) {
        val currentSection = sections[position]
        val articlesAdapter = currentSection.articles?.let { ArticlesAdapter(it) }

        holder.itemView.apply {
            tv_section_title.text = currentSection.title
             rv_articles.adapter = articlesAdapter
             rv_articles.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

    }
}
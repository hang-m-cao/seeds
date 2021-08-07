package com.example.tshlib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.saved_article_card.view.*

class SavedArticlesAdapter (private val articles : MutableList<Article>):
    RecyclerView.Adapter<SavedArticlesAdapter.SavedArticlesViewHolder>() {

    class SavedArticlesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedArticlesViewHolder {
        return SavedArticlesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.saved_article_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SavedArticlesViewHolder, position: Int) {
        val currArticle = articles[position]

        holder.itemView.apply {
            article_title.text = currArticle.title

            article_tag.text = currArticle.tag

            remove_button.setOnClickListener {
                articles.remove(currArticle)
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

}
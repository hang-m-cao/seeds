package com.example.tshlib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.article_card.view.*

class ArticlesAdapter (private val articles : MutableList<Article>):
    RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    class ArticlesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.article_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val currArticle = articles[position]

        holder.itemView.apply {
            articleTitle.text = currArticle.title

            if (currArticle.saved) {
                heartLiked.visibility = View.VISIBLE
                heartUnliked.visibility = View.INVISIBLE
            } else {
                heartLiked.visibility = View.INVISIBLE
                heartUnliked.visibility = View.VISIBLE
            }

            heartLiked.setOnClickListener{
                heartLiked.visibility = View.INVISIBLE
                heartUnliked.visibility = View.VISIBLE
            }

            heartUnliked.setOnClickListener{
                heartLiked.visibility = View.VISIBLE
                heartUnliked.visibility = View.INVISIBLE
            }

        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }



}
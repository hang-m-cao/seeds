package com.example.tshlib

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
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

            currArticle.image?.let { Log.d("article", it) }

            if (currArticle.image == null) {
                articlePic.visibility = View.GONE
            }
            else {
                Picasso.get().load(currArticle.image).resize(200, 0)
                    .centerCrop().into(articlePic)
            }

        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }



}
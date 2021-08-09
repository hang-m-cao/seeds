package com.example.tshlib

import android.telecom.Call
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_card.view.*
import java.lang.Exception

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
            article_title.text = currArticle.title

            if (currArticle.saved) {
                heart_liked.visibility = View.VISIBLE
                heart_unliked.visibility = View.INVISIBLE
            } else {
                heart_liked.visibility = View.INVISIBLE
                heart_unliked.visibility = View.VISIBLE
            }

            heart_liked.setOnClickListener{
                heart_liked.visibility = View.INVISIBLE
                heart_unliked.visibility = View.VISIBLE
            }

            heart_unliked.setOnClickListener{
                heart_liked.visibility = View.VISIBLE
                heart_unliked.visibility = View.INVISIBLE
            }

            if (!currArticle.image.isNullOrBlank()) {
                Picasso.get().load(currArticle.image).fit()
                    .centerCrop().into(article_pic, object: Callback {
                        override fun onSuccess() {
                            Log.d("picasso", "successfully added image")
                        }

                        override fun onError(e: Exception?) {
                            article_pic.visibility = View.GONE
                            Log.d("picasso", e.toString())
                        }

                    })
            } else {
                article_pic.visibility = View.GONE
            }

        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }



}
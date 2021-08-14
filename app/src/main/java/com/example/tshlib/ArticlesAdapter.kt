package com.example.tshlib

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
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
            article_card.setOnClickListener {
                val intent = Intent(context, ArticleViewActivity::class.java)

                intent.putExtra("link", currArticle.link)
                context.startActivity(intent)

            }
            var db = SavedArticlesDB.getInstance(holder.itemView.context).articleDAO()
            article_title.text = currArticle.title
            var currlist = db.getArticle(currArticle.id)
            if (currlist.isNotEmpty()) {
                heart_liked.visibility = View.VISIBLE
                heart_unliked.visibility = View.INVISIBLE
            } else {
                heart_liked.visibility = View.INVISIBLE
                heart_unliked.visibility = View.VISIBLE
            }

            heart_liked.setOnClickListener{
                heart_liked.visibility = View.INVISIBLE
                heart_unliked.visibility = View.VISIBLE
                db.deleteArticle(currArticle)
            }

            heart_unliked.setOnClickListener{
                heart_liked.visibility = View.VISIBLE
                heart_unliked.visibility = View.INVISIBLE
                db.insertArticle(currArticle)
            }

            if (!currArticle.image.isNullOrBlank()) {
                article_pic.visibility = View.VISIBLE
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
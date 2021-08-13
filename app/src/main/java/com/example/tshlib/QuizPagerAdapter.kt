package com.example.tshlib

import android.os.Build
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_quiz.view.*
import kotlinx.android.synthetic.main.fragment_quiz_section.view.*

class QuizPagerAdapter
    (private val q1: List<Int>, private val q2: List<Int>):
    RecyclerView.Adapter<QuizPagerAdapter.QuizPagerHolder>() {
    inner class QuizPagerHolder(view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizPagerHolder {
        return QuizPagerHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_quiz_section, parent, false)
        )
    }


    override fun onBindViewHolder(holder: QuizPagerHolder, position: Int) {
        var score_priv : Int = 0


        holder.itemView.apply {


            val opt1 : Button = findViewById(R.id.option1)
            opt1.setOnClickListener{
                score_priv = score_priv +1
            }
            val opt2 : Button = findViewById(R.id.option2)
            opt2.setOnClickListener{
                score_priv = score_priv +1
            }
            val opt3 : Button = findViewById(R.id.option3)
            opt3.setOnClickListener{
                score_priv = score_priv +1
            }
            val opt4 : Button = findViewById(R.id.option4)
            opt4.setOnClickListener{
                score_priv = score_priv +1
            }
            question1.text = resources.getString(q1[position])
            question2.text = resources.getString(q2[position])

            val submitbtn : Button = findViewById(R.id.submit)
            if (position==3){
                submitbtn.visibility= View.VISIBLE
                Global.score=score_priv
            }

        }

    }

    override fun getItemCount(): Int {
        return q1.size
    }

}
package com.example.tshlib

import android.content.Context
import android.os.Build
import android.content.Intent
import android.preference.PreferenceManager
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.util.Log
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
    var score_priv : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizPagerHolder {
        return QuizPagerHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_quiz_section, parent, false)
        )
    }


    override fun onBindViewHolder(holder: QuizPagerHolder, position: Int) {

        holder.itemView.apply {
            question1.text = resources.getString(q1[position])
            question2.text = resources.getString(q2[position])
            val opt1 : Button = findViewById(R.id.option1)
            opt1.setOnClickListener{
                score_priv += 1
                Log.d("add_score", "Yep"+ score_priv.toString())
            }
            val opt2 : Button = findViewById(R.id.option2)
            opt2.setOnClickListener{
                score_priv += 1
                Log.d("add_score", "Yep"+ score_priv.toString())
            }
            val opt3 : Button = findViewById(R.id.option3)
            opt3.setOnClickListener{
                score_priv += 1
                Log.d("add_score", "Yep"+ score_priv.toString())
            }
            val opt4 : Button = findViewById(R.id.option4)
            opt4.setOnClickListener{
                score_priv += 1
                Log.d("add_score", "Yep"+ score_priv.toString())

            }

            val submitBtn : Button = findViewById(R.id.submit)
            submitBtn.setOnClickListener{
                var sharedPreferences = context.getSharedPreferences("user_score", Context.MODE_PRIVATE)
                var editor = sharedPreferences.edit()
                editor.putInt("score",score_priv)
                editor.commit()
                val intent = Intent(context, QuizResults::class.java)
                context.startActivity(intent)
            }

            if (position==3){
                submitBtn.visibility= View.VISIBLE

            }


        }

    }

    override fun getItemCount(): Int {
        return q1.size
    }

}
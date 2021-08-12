package com.example.tshlib

import android.os.Build
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_quiz.view.*
import kotlinx.android.synthetic.main.fragment_quiz_section.view.*

class QuizPagerAdapter
    (private val questions: MutableList<MutableList<Question>>, private val q1: List<Int>, private val q2: List<Int>):
    RecyclerView.Adapter<QuizPagerAdapter.QuizPagerHolder>() {
    inner class QuizPagerHolder(view: View) : RecyclerView.ViewHolder(view)


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
        }

    }

    override fun getItemCount(): Int {
        return questions.size
    }

}
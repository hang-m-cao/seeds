package com.example.tshlib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_quiz_section.view.*
import androidx.recyclerview.widget.RecyclerView

class QuizPagerAdapter
    (private val questions: MutableList<MutableList<Question>>):
    RecyclerView.Adapter<QuizPagerAdapter.QuizPageHolder>() {
    inner class QuizPageHolder(view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizPageHolder {
        return QuizPageHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_quiz_section, parent, false)
        )
    }


    override fun onBindViewHolder(holder: QuizPageHolder, position: Int) {
        holder.itemView.apply {
            textView.text = "Potatoes are great, amazing $position"
        }
    }

    override fun getItemCount(): Int {
        return questions.size
    }

}

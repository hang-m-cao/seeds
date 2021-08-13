package com.example.tshlib

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_quiz_section.view.*

class QuizPagerAdapter
    (private val q1: List<Int>, private val q2: List<Int>):
    RecyclerView.Adapter<QuizPagerAdapter.QuizPagerHolder>() {
    inner class QuizPagerHolder(view: View) : RecyclerView.ViewHolder(view)
    var scorePriv : Int = 0

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
                scorePriv += 1
                Log.d("add_score", "Yep$scorePriv")
            }
            val opt2 : Button = findViewById(R.id.option2)
            opt2.setOnClickListener{
                scorePriv += 1
                Log.d("add_score", "Yep$scorePriv")
            }
            val opt3 : Button = findViewById(R.id.option3)
            opt3.setOnClickListener{
                scorePriv += 1
                Log.d("add_score", "Yep$scorePriv")
            }
            val opt4 : Button = findViewById(R.id.option4)
            opt4.setOnClickListener{
                scorePriv += 1
                Log.d("add_score", "Yep$scorePriv")

            }

            val submitBtn : Button = findViewById(R.id.submit)
            submitBtn.setOnClickListener{
                val intent = Intent(context, QuizResultActivity::class.java)
                val sharedPreferences = context.getSharedPreferences("user_score", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putInt("score",scorePriv)
                editor.commit()
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
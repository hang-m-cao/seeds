package com.example.tshlib

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class QuizFragment: Fragment(R.layout.fragment_quiz) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataset = QuizDataSource().loadQuizTopics()
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_quiz_content)
        recyclerView.adapter = QuizAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
    }
}
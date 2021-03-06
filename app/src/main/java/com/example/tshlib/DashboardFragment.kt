package com.example.tshlib

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class DashboardFragment: Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.take_quiz_btn).setOnClickListener {
            val intent = Intent(activity, QuizStartingActivity::class.java)
            activity?.startActivity(intent)
        }
    }


}
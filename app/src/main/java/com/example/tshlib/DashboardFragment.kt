package com.example.tshlib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment: Fragment(R.layout.fragment_dashboard){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_quiz.setOnClickListener{v ->
            Navigation.findNavController(v).navigate(R.id.action_dashboardFragment_to_quizFragment);
    }
}
}

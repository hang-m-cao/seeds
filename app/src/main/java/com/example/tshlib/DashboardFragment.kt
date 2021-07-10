package com.example.tshlib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment: Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        btn_quiz.setOnClickListener {
            val navHostFragment = (activity as FragmentActivity).supportFragmentManager.findFragmentById(R.id.fcv_dashboard) as NavHostFragment
            val navController = navHostFragment.navController
            val action = DashboardFragmentDirections.actionDashboardFragmentToQuizFragment()
            navController.navigate(action)
        }






    }


}
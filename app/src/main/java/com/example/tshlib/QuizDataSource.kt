package com.example.tshlib

class QuizDataSource {
    fun loadQuizTopics(): List<QuizSection> {
        return listOf<QuizSection>(
            QuizSection(R.string.quiztopic1),
            QuizSection(R.string.quiztopic2),
            QuizSection(R.string.quiztopic3),
            QuizSection(R.string.quiztopic4)



        )
    }
}
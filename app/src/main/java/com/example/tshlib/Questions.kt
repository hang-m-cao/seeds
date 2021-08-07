package com.example.tshlib

class Questions {
    inner class Question// setting the values through
    // arguments passed in constructor
    // answerTrue will store correct answer
    // of the question provided
        (// setting the question passed
        // returning the question passed
        var answerInput: Int, private var score: Int
    ) {
        // returning the correct answer
        // of question
        fun updateScore(): Int {
            return score
        }

        // setting the correct
        // ans of question
        fun setAnswerTrue(score: Int) {
            this.score = score
        }
    }
}
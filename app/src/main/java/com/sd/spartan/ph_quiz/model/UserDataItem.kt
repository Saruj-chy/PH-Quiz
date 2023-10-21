package com.sd.spartan.ph_quiz.model

data class UserDataItem(
    val answers: Answers,
    val correctAnswer: String,
    val question: String,
    val questionImageUrl: Any,
    val score: Int
)
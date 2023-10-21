package com.sd.spartan.ph_quiz.screenItem

sealed class ScreenItem(val route: String){
    object SplashScreenItem: ScreenItem("splash_screen")
    object HomeScreenItem: ScreenItem("home_screen")
    object QAScreen: ScreenItem("question_answer")

}
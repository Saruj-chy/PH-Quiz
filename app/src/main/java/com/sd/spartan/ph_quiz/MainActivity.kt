package com.sd.spartan.ph_quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sd.spartan.ph_quiz.screenItem.ScreenItem
import com.sd.spartan.ph_quiz.screens.HomeScreen
import com.sd.spartan.ph_quiz.screens.QAScreen
import com.sd.spartan.ph_quiz.ui.theme.PHQuizTheme
import com.sd.spartan.ph_quiz.ui.theme.PrimaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PHQuizTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setStatusBarColor(PrimaryColor)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenItem.HomeScreenItem.route
                    ) {
                        composable(ScreenItem.HomeScreenItem.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(ScreenItem.QAScreen.route) {
                            QAScreen(navController = navController)
                        }

                    }
                }
            }
        }
    }
}








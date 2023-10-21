package com.sd.spartan.ph_quiz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sd.spartan.ph_quiz.R
import com.sd.spartan.ph_quiz.screenItem.ScreenItem
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController = NavController(LocalContext.current)){
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack()
        navController.navigate(ScreenItem.HomeScreenItem.route)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.mipmap.ph_logo),"Programing Hero Logo",
            modifier = Modifier.width(300.dp),
            contentScale = ContentScale.FillWidth
        )
    }
}
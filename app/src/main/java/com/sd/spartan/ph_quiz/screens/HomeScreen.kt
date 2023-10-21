package com.sd.spartan.ph_quiz.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sd.spartan.ph_quiz.R
import com.sd.spartan.ph_quiz.screenItem.ScreenItem

//@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavController){
    Home(navController)
}
@Composable
fun Home(navController: NavController){
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier.padding(bottom = 60.dp)

            ) {

                Column(modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.mipmap.ph_logo), "Programing Hero Logo",
                        modifier = Modifier.width(150.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        fontSize = 24.sp,
                        text = "Programming Hero"
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally), fontSize = 25.sp,
                        text = "Quiz"
                    )
                }


            }
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = "Highscore",
                fontSize = 20.sp
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = "500 Point",
                fontSize = 18.sp
            )
            Button(onClick = {
                Log.e("btn", "start msg click")
                navController.navigate(ScreenItem.QAScreen.route)

            }, modifier = Modifier
                .padding(top = 60.dp)) {
                Text(text = "Start",
                    modifier = Modifier
                        .padding(horizontal = 50.dp, vertical = 5.dp),
                    fontSize = 20.sp)

            }

        }
    }
}
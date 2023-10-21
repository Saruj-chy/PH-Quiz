package com.sd.spartan.ph_quiz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sd.spartan.ph_quiz.R
import com.sd.spartan.ph_quiz.screenItem.ScreenItem
import com.sd.spartan.ph_quiz.ui.theme.PrimaryColor

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
                .fillMaxHeight()
                .background(PrimaryColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier.padding(bottom = 60.dp)

            ) {

                Column(modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.mipmap.ph_logo),
                        "Programing Hero Logo",
                        modifier = Modifier.width(150.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        fontSize = 30.sp,
                        text = "Programming Hero"
                    )
                    Text(
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Quiz"
                    )
                }


            }
            Text(
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = "Highscore",

                fontSize = 30.sp
            )
            Text(
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = "500 Point",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(Modifier.height(60.dp))
            Card(
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .fillMaxWidth()
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                navController.navigate(ScreenItem.QAScreen.route)
                            }
                        )
                    },
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(text = "Start",
                    modifier = Modifier
                        .padding(horizontal = 50.dp, vertical = 5.dp)
                        .align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp)

            }


        }
    }
}
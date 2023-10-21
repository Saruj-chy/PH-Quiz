package com.sd.spartan.ph_quiz.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.sd.spartan.ph_quiz.R
import org.json.JSONException
import java.util.HashMap

//@Preview(showBackground = true)
@Composable
fun QAScreen(navController: NavController){
    val context = LocalContext.current
//    getData(LocalContext.current)
    Surface() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth()){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box() {
                        Row {
                            Text(
                                modifier = Modifier,
                                fontSize = 18.sp,
                                text = "Question: "
                            )
                            Text(
                                modifier = Modifier,
                                fontSize = 18.sp,
                                text = "2/10"
                            )
                        }
                    }
                    Box() {
                        Row {
                            Text(
                                modifier = Modifier,
                                fontSize = 18.sp,
                                text = "Score: "
                            )
                            Text(
                                modifier = Modifier,
                                fontSize = 18.sp,
                                text = "300"
                            )
                        }
                    }


                }
                Spacer(Modifier.height(60.dp))

                Box(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Green),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),

                            fontSize = 20.sp,
                            text = "100 Point"
                        )
                        Image(
                            painter = painterResource(R.mipmap.ph_logo), "Programing Hero Logo",
                            modifier = Modifier.width(150.dp),
                            contentScale = ContentScale.FillWidth
                        )
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            fontSize = 20.sp,
                            text = "What is this logo?"
                        )

                    }
                }
                Spacer(Modifier.height(60.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            fontSize = 20.sp,
                            text = "CSS"
                        )
                        Button(onClick = {
                            getData(context)
                        }) {
                            Text(text = "Click")
                        }

                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            fontSize = 20.sp,
                            text = "BOOTSTRAP"
                        )
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            fontSize = 20.sp,
                            text = "BOOTSTRAP"
                        )
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            fontSize = 20.sp,
                            text = "BOOTSTRAP"
                        )

                    }
                }
            }
        }
    }
}
fun getData(context: Context) {
    val myUrl = "https://herosapp.nyc3.digitaloceanspaces.com/quiz.json"
    val stringRequest: StringRequest = object : StringRequest( Method.GET, myUrl,
        Response.Listener { response ->
            try {
                Log.d("res", "getData res: $response")


            } catch (e: JSONException) {
                Log.d("res", "getData: $e")

                e.printStackTrace()
            }
        },
        Response.ErrorListener { error ->
            Log.d("res", "getData: $error")

//            Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
        }) {

    }
    val requestQueue = Volley.newRequestQueue(context)
    requestQueue.add(stringRequest)


}

package com.sd.spartan.ph_quiz.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.sd.spartan.ph_quiz.R
import com.sd.spartan.ph_quiz.model.UserData
import com.sd.spartan.ph_quiz.model.UserDataItem
import com.sd.spartan.ph_quiz.ui.theme.PrimaryColor
import org.json.JSONArray
import org.json.JSONObject

val selectAnsA = mutableStateOf("null")
val selectAnsB = mutableStateOf("null")
val selectAnsC = mutableStateOf("null")
val selectAnsD = mutableStateOf("null")
@Composable
fun QAScreen(navController: NavController){
    MainQAScreen()
}

@Composable
fun GetData(){
    val context = LocalContext.current
    val myUrl = "https://herosapp.nyc3.digitaloceanspaces.com/quiz.json"

    val userData = UserData()
    val data = remember {
        mutableStateOf<UserData>(UserData())
    }
    val stringRequest = StringRequest(myUrl,{
        val jsonObj = JSONObject(it)
        val jsonArray: JSONArray = jsonObj.getJSONArray("questions")
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()

        gson.fromJson(jsonArray.toString(), Array<UserDataItem>::class.java)?.forEach{
            userData.add(it)
        }
        data.value= userData


    },{

    }).apply {
        LazyColumn{

            items(data.value) {
                    data-> ViewData(data = data)
            }
        }
    }
    val requestQueue = Volley.newRequestQueue(context)
    requestQueue.add(stringRequest)


}

@Composable
fun MainQAScreen(){
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
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box() {
                        Row {
                            Text(
                                modifier = Modifier,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                text = "Question: "
                            )
                            Text(
                                modifier = Modifier,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                text = "2/10"
                            )
                        }
                    }
                    Box() {
                        Row {
                            Text(
                                modifier = Modifier,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                text = "Score: "
                            )
                            Text(
                                modifier = Modifier,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                text = "300"
                            )
                        }
                    }


                }
                Box(modifier = Modifier.background(PrimaryColor)){
                    GetData()
                }

            }
        }
    }
}

@Composable
fun ViewData(data: UserDataItem){

    val modifier1 = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .border(BorderStroke(2.dp, Color.Green))

    val modifier2 = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentHeight()

    Column(modifier =Modifier){
        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.medium,

            ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
//                Log.e("data", "url:"+ data.questionImageUrl)
                    Spacer(Modifier.height(50.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        text = "${data.score} Point"
                    )
                    Spacer(Modifier.height(50.dp))
                    AsyncImage(
                        modifier = Modifier.width(150.dp),
                        model = "${data.questionImageUrl}",
                        placeholder = painterResource(id = R.mipmap.ph_logo),
                        error = painterResource(id = R.mipmap.ph_logo),
                        contentDescription = "The ph logo",
                    )
                    Spacer(Modifier.height(50.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        text = data.question
                    )
                    Spacer(Modifier.height(50.dp))


                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                if(data.answers.A !=null){
                    Card(
                        modifier = if (selectAnsA.value == data.correctAnswer) {
                            modifier1
                        } else {
                            modifier2
                        },
                        shape = MaterialTheme.shapes.medium,

                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 5.dp)
                                .align(Alignment.CenterHorizontally).pointerInput(Unit) {
                                    detectTapGestures(
                                        onPress = {
                                            selectAnsA.value = "A"
                                        }
                                    )
                                }
                            ,
                            fontSize = 20.sp,
                            text = data.answers.A
                        )

                    }
                }

                if(data.answers.B !=null){
                    Card(
                        modifier =  if (selectAnsB.value == data.correctAnswer) {
                            modifier1
                        } else {
                            modifier2
                        } ,
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 5.dp)
                                .align(Alignment.CenterHorizontally).pointerInput(Unit) {
                                    detectTapGestures(
                                        onPress = {
                                            selectAnsB.value = "B"
                                        }
                                    )
                                },
                            fontSize = 20.sp,
                            text = "${data.answers.B}"
                        )
                    }
                }
                if(data.answers.C !=null){
                    Card(
                        modifier = if (selectAnsC.value == data.correctAnswer) {
                            modifier1
                        } else {
                            modifier2
                        },
                        shape = MaterialTheme.shapes.medium,

                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 5.dp)
                                .align(Alignment.CenterHorizontally).pointerInput(Unit) {
                                    detectTapGestures(
                                        onPress = {
                                            selectAnsC.value = "C"
                                        }
                                    )
                                },
                            fontSize = 20.sp,
                            text = data.answers.C
                        )
                    }
                }
                if(data.answers.D !=null){
                    Card(
                        modifier = if (selectAnsD.value == data.correctAnswer) {
                            modifier1
                        } else {
                            modifier2
                        },
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 5.dp)
                                .align(Alignment.CenterHorizontally).pointerInput(Unit) {
                                    detectTapGestures(
                                        onPress = {
                                            selectAnsD.value = "D"
                                        }
                                    )
                                },
                            fontSize = 20.sp,
                            text = data.answers.D
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(100.dp))

    }
}

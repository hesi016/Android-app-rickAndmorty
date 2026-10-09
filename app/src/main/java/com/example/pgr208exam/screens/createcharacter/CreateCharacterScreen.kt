package com.example.pgr208exam.screens.createcharacter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pgr208exam.R

@Composable
fun CreateCharacterScreen( viewModel: CreateCharacterViewModel,
                           navController: NavController
) {

    var name by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var status by rememberSaveable { mutableStateOf("") }
    var message by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){

        Image(
            painter = painterResource(id = R.drawable.rickandmortybackground),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(9.dp)
                .size(width = 100.dp, height = 40.dp)
        ) {
            Text(text = "Go back",
                color = Color.Blue,
                fontSize = 12.sp)
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            HeadingShadow()

            if (message.isNotEmpty())
            {
                Text(text = message,
                    color = Color.Red,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 8.dp, bottom = 10.dp)
                )
            }


            Spacer(modifier = Modifier.padding(20.dp))
            InputField(
                value = name ,
                onValueChange ={ name =it } ,
                label = "Enter Name"
            )

            Spacer(modifier = Modifier.padding(10.dp))

            InputField(
                value = gender ,
                onValueChange ={ gender =it } ,
                label = "Enter Gender"
            )

            Spacer(modifier = Modifier.padding(10.dp))

            InputField(
                value = status ,
                onValueChange ={ status =it } ,
                label = "Enter Status"
            )

            Spacer(modifier = Modifier.padding(20.dp))


            AddButton(onAddButtonClicked = {
                if(name.isNotBlank() && gender.isNotBlank() && status.isNotBlank()) {
                    viewModel.addInventedCharacters(
                        name,
                        gender,
                        status
                    )
                    name = ""
                    gender = ""
                    status = ""
                } else {
                    message ="Fill all the fields!"
                }
            })
        }
    }
}

@Composable
fun HeadingShadow() {
    val offset = Offset(9.0f, 8.0f)
    Text(text = "MAKE YOUR OWN CHARACTER",
        style = MaterialTheme.typography.headlineLarge.copy(
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            shadow = Shadow(
                color = Color.Blue, offset = offset, blurRadius = 3f
            )
        )
    )
}

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    shape: RoundedCornerShape =RoundedCornerShape(10.dp),
    indicatorColor: Color = Color.Magenta,
    unfocusedIndicatorColor: Color = Color.Green

) {
    OutlinedTextField(
        value = value ,
        onValueChange = onValueChange,
        label = { Text(text = label, color = Color.Magenta) },
        shape = shape,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = indicatorColor,
            unfocusedIndicatorColor = unfocusedIndicatorColor)
    )
}

@Composable
        fun AddButton(onAddButtonClicked: () -> Unit) {
            Button(
                onClick = onAddButtonClicked,
                modifier = Modifier,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                )
            ) {
                Text(text = "ADD CHARACTER",
                    fontSize = 18.sp,
                    color = Color.White)
            }
        }
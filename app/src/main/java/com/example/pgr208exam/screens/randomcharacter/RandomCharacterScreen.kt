package com.example.pgr208exam.screens.randomcharacter


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.pgr208exam.R
import com.example.pgr208exam.data.api.Character

@Composable
fun RandomCharacterScreen(
    characterList: List<Character>,
    viewModel: RandomCharacterViewModel,
    navController: NavController
) {

    val randomCharacter by viewModel.randomcharacter.collectAsState()
    var blackBackground by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if(blackBackground) Color.Black else Color.Transparent)
    ) {
        if(!blackBackground) {
            Image(
                painter = painterResource(id = R.drawable.gamebackground),
                contentDescription = "Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )

        }

        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(9.dp)
                .size(width = 100.dp, height = 40.dp)
        ) {
            Text(text = "Go back",
                color = Color.Blue)
        }

        randomCharacter?.let { character ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(60.dp)
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Spacer(modifier = Modifier.height(163.dp))

                Text(
                    text = character.name.uppercase(),
                    fontSize = 40.sp,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    lineHeight = 48.sp,
                    modifier = Modifier
                        .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                        .border(
                            width = 3.dp, color = Color.White, shape = RoundedCornerShape(8.dp)
                        )
                )

                Image(
                    painter = rememberAsyncImagePainter(model = character.image),
                    contentDescription = "Random Character",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(250.dp)
                        .clip(RoundedCornerShape(10))
                )

            }
        }

        Button(
            onClick = { viewModel.fetchRandomCharacter(characterList)
                      blackBackground = true
                      },
            colors = ButtonDefaults.buttonColors(Color.Red),
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "Random Character",
                fontSize = 28.sp
            )
        }
    }
}
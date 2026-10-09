package com.example.pgr208exam.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pgr208exam.R


    val buttonSize = Modifier
        .size(width = 250.dp, height = 55.dp)
        .padding(vertical = 5.dp)


@Composable
fun FirstPage(
    onButton1Click: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit,
    onButton4Click: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.frontpage),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.padding(top = 190.dp))

            NavigationButton(
                text = "View characterlist",
                onClick = onButton1Click,
            )
            NavigationButton(
                text = "Your characters",
                onClick = onButton2Click,
            )
            NavigationButton(
                text = "Create character",
                onClick = onButton3Click,
            )
            NavigationButton(
                text = "Random character",
                onClick = onButton4Click,
            )
        }
    }
}

    @Composable
    fun NavigationButton(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
            .size(250.dp, 55.dp)
            .padding(5.dp)
    ) {
        Button(
            onClick = onClick,
            modifier = modifier,
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text(
                    text = text,
                    fontSize = 18.sp,
                    color = Color.Green
                )
        }
    }
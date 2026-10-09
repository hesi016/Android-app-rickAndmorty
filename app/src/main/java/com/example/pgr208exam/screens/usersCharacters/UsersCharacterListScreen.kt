package com.example.pgr208exam.screens.usersCharacters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pgr208exam.R


@Composable
fun UsersCharacterListScreen(
    viewModel: UsersCharacterViewModel,
    navController: NavController
) {
    val allUsersCharacters by viewModel.allUsersCharacters.observeAsState(emptyList())

    Box(
        modifier = Modifier.fillMaxSize()

    )
    {
        Image(
            painter = painterResource(id = R.drawable.userscharacterbackground),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(9.dp)
                .size(width = 100.dp, height = 40.dp)
        ) {
            Text(text = "Go back",
                color = Color.Blue
            )
        }
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Characters Invented By You",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(25.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (allUsersCharacters.isNotEmpty()) {
                    items(allUsersCharacters) { character ->
                        UsersCharacterItem(
                            character = character,
                            onDeleteClick = { viewModel.deleteCharacter(character.id) }
                        )
                    }
                } else {
                    item {
                        Text(
                            text = "No characters have been made yet...",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }
            }
        }
    }
}
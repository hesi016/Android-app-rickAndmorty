package com.example.pgr208exam.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pgr208exam.screens.characterlist.CharacterListScreen
import com.example.pgr208exam.screens.characterlist.CharacterListViewModel
import com.example.pgr208exam.screens.createcharacter.CreateCharacterScreen
import com.example.pgr208exam.screens.createcharacter.CreateCharacterViewModel
import com.example.pgr208exam.screens.randomcharacter.RandomCharacterScreen
import com.example.pgr208exam.screens.randomcharacter.RandomCharacterViewModel
import com.example.pgr208exam.screens.usersCharacters.UsersCharacterListScreen
import com.example.pgr208exam.screens.usersCharacters.UsersCharacterViewModel


@Composable
fun AppNavHost() {

    val navController = rememberNavController()
    val _characterListViewModel: CharacterListViewModel = viewModel()
    val characterList = _characterListViewModel.characters.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = "first_page"
    ) {
        composable(Screens.FirstPage.route) {
            FirstPage(
                onButton1Click = { navController.navigate(Screens.CharacterList.route) },
                onButton2Click = { navController.navigate(Screens.UsersCharacters.route) },
                onButton3Click = { navController.navigate(Screens.CreateCharacters.route) },
                onButton4Click = { navController.navigate(Screens.RandomCharacters.route) }
            )
        }

        composable(Screens.CharacterList.route) {
            CharacterListScreen(
                viewModel = CharacterListViewModel(),
                navController = navController
            )
        }
        composable(Screens.UsersCharacters.route) {
            UsersCharacterListScreen(
                viewModel = UsersCharacterViewModel(),
                navController = navController
            )
        }
        composable(Screens.CreateCharacters.route) {
            CreateCharacterScreen(
                viewModel = CreateCharacterViewModel(),
                navController = navController
            )
        }
        composable(Screens.RandomCharacters.route) {
            RandomCharacterScreen(
                viewModel = RandomCharacterViewModel(),
                characterList = characterList,
                navController = navController
            )
        }
    }
}
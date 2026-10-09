package com.example.pgr208exam.navigation

sealed class Screens(val route: String) {
    data object FirstPage : Screens("first_page")
    data object CharacterList : Screens("character_list")
    data object UsersCharacters : Screens("users_characters")
    data object CreateCharacters : Screens("create_characters")
    data object RandomCharacters : Screens("random_characters")

}
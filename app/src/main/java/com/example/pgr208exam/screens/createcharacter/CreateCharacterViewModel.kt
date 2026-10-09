package com.example.pgr208exam.screens.createcharacter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pgr208exam.app.MainApplication
import com.example.pgr208exam.data.database.UsersCharacters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateCharacterViewModel: ViewModel() {

    private val usersCharactersDao = MainApplication.usersCharacterDatabase.usersCharactersDao()


    fun addInventedCharacters(name: String, gender: String, status: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                usersCharactersDao.addCharacters(
                    UsersCharacters(
                        name = name,
                        gender = gender,
                        status = status
                    )
                )
                Log.i("CreateCharacterViewModel", "Character successfully added to database")


            } catch (e: Exception) {
                Log.e("CreateCharacterViewModel", "Error adding character to database", e)
            }
        }
    }
}

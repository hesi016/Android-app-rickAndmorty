package com.example.pgr208exam.screens.usersCharacters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pgr208exam.app.MainApplication
import com.example.pgr208exam.data.database.UsersCharacters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UsersCharacterViewModel : ViewModel() {

    private val usersCharactersDao = MainApplication.usersCharacterDatabase.usersCharactersDao()
    val allUsersCharacters: LiveData<List<UsersCharacters>> = usersCharactersDao.getAllCharacters()

    fun deleteCharacter(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                usersCharactersDao.deleteCharacter(id)

                Log.i("UsersCharacterViewModel", "Character with id= $id successfully deleted")
            } catch (e: Exception) {
                Log.e("UsersCharacterViewModel", "Error deleting Character with id= $id", e)
            }
        }
    }
}
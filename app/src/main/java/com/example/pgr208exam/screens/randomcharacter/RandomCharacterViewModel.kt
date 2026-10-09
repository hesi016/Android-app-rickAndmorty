package com.example.pgr208exam.screens.randomcharacter



import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.pgr208exam.data.api.Character
import kotlin.random.Random


class RandomCharacterViewModel : ViewModel() {

    private val _randomcharacter = MutableStateFlow<Character?>(null)
    val randomcharacter = _randomcharacter.asStateFlow()

    fun fetchRandomCharacter(characters: List<Character>) {
        if(characters.isNotEmpty()) {
            _randomcharacter.value = characters[Random.nextInt(characters.size)]

            Log.i("RandomCharacterViewModel", "Random character selected")
        } else {
            Log.e("RandomCharacterViewModel", "No character selected. Characters list is empty...")
        }
    }
}
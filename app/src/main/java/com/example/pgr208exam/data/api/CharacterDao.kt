package com.example.pgr208exam.data.api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {

    @Query("SELECT * FROM Character")
    suspend fun getCharacters(): List<Character>

    @Query("SELECT * FROM Character WHERE :id = id")
    suspend fun getCharacterById(id: Int): Character?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<Character>)
}
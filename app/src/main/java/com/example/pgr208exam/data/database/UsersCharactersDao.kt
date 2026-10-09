package com.example.pgr208exam.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UsersCharactersDao {

    @Query("SELECT * FROM UsersCharacters")
    fun getAllCharacters(): LiveData<List<UsersCharacters>>

    @Query("DELETE FROM UsersCharacters WHERE id = :id")
    fun deleteCharacter(id: Int)

    // burde ha parameteret inne for å ikke få feilmeldinger
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addCharacters(character: UsersCharacters)

}
package com.example.pgr208exam.data.database


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UsersCharacters::class],
    version = 1,
    exportSchema = false
)

abstract class UsersCharacterDatabase: RoomDatabase() {
    abstract fun usersCharactersDao(): UsersCharactersDao

}
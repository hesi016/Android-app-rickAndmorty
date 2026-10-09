package com.example.pgr208exam.data.api

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Character::class],
    version = 1,
    exportSchema = false
)

abstract  class ApiDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
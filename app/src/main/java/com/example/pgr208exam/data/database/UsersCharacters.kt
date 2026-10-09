package com.example.pgr208exam.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UsersCharacters")
data class UsersCharacters(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val gender: String,
    val status: String

)
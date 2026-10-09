package com.example.pgr208exam.data.api

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character(

    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val gender: String,
    val image: String
)
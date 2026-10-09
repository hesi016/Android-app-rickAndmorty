package com.example.pgr208exam.app

import android.app.Application
import androidx.room.Room
import com.example.pgr208exam.data.database.UsersCharacterDatabase

class MainApplication : Application() {
    companion object{
        lateinit var usersCharacterDatabase: UsersCharacterDatabase
    }

    override fun onCreate() {
        super.onCreate()
        usersCharacterDatabase =
            Room.databaseBuilder(applicationContext,
            UsersCharacterDatabase::class.java,
            "UsersCharacters").build()
    }
}
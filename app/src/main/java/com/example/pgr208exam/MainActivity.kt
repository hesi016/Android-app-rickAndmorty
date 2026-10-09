package com.example.pgr208exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pgr208exam.navigation.AppNavHost
import com.example.pgr208exam.data.api.ApiRepository
import com.example.pgr208exam.theme.PGR208ExamTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApiRepository.initializeDatabase(applicationContext)

        setContent {
            PGR208ExamTheme {
                AppNavHost()

            }
        }
    }
}
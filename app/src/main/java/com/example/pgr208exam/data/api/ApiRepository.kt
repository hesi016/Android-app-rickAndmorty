package com.example.pgr208exam.data.api

import android.content.Context
import android.util.Log
import androidx.room.Room

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRepository {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val _httpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()

    private val _retrofit =
        Retrofit.Builder()
            .client(_httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    private val _apiService = _retrofit.create(ApiService::class.java)

    private lateinit var _apiDatabase: ApiDatabase
    private val _characterDao by lazy { _apiDatabase.characterDao() }

    fun initializeDatabase(context: Context) {
        _apiDatabase = Room.databaseBuilder(
            context = context,
            klass = ApiDatabase::class.java,
            name = "RickAndMortyCharacters"
        ).build()
    }

    suspend fun getFiftyCharacters(): List<Character> {
        try {
            val ids = (1..51).joinToString(separator = ",")

            val response = _apiService.getCharactersById(ids)

            if (response.isSuccessful) {

                val characters = response.body() ?: emptyList()

                _characterDao.insertCharacters(characters)

                return _characterDao.getCharacters()
            } else {
                throw Exception("Response var ikke en suksess")
            }
        } catch (e: Exception) {
            Log.e("ApiRepository", "Kunne ikke hente karakterene", e)
            return _characterDao.getCharacters()
        }
    }
}
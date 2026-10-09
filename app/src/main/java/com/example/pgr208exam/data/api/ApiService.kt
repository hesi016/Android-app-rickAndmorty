package com.example.pgr208exam.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character/{id}")
    suspend fun getCharactersById(
        @Path("id") id: String
    ): Response<List<Character>>
}
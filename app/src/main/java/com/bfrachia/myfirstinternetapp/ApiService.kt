package com.bfrachia.myfirstinternetapp

import com.bfrachia.myfirstinternetapp.model.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("characters")
    fun listCharacters(
        @Query("apikey") apiKey: String,
        @Query("orderBy") orderBy: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
    ): Call<CharactersResponse>

}
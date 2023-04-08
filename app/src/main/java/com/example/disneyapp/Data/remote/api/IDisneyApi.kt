package com.example.disneyapp.Data.remote.api

import com.example.disneyapp.Model.DisneyModel
import com.example.disneyapp.Util.Constant.Companion.CharactersUrl
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IDisneyApi {
    @GET(CharactersUrl)
    suspend fun getDisney() : Response<DisneyModel>

    @GET("CharactersUrl")
    suspend fun getOneCharacter(@Query("id") id: String) : Response<DisneyModel>
}
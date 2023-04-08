package com.example.disneyapp.Data.remote.api

import com.example.disneyapp.Model.DisneyData
import com.example.disneyapp.Model.DisneyModel
import com.example.disneyapp.Util.Constant.Companion.CharactersUrl
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IDisneyApi {

    @GET(CharactersUrl)
    suspend fun getDisney() : Response<DisneyModel>

    @GET("${CharactersUrl}/{id}")
    suspend fun getOneCharacter(@Path("id") id : Int) : Response<DisneyData>
}
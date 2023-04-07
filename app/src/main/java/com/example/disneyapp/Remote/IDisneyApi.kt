package com.example.disneyapp.Remote

import com.example.disneyapp.Model.DisneyModel
import com.example.disneyapp.Util.Constant.Companion.CharactersUrl
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface IDisneyApi {

    @GET(CharactersUrl)
    suspend fun getDisney() : Response<DisneyModel>
}
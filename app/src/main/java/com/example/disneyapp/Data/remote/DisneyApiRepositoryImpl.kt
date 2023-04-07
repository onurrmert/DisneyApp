package com.example.disneyapp.Data.remote

import com.example.disneyapp.Data.remote.api.IDisneyApi
import com.example.disneyapp.Model.DisneyData
import javax.inject.Inject

class DisneyApiRepositoryImpl @Inject constructor(
    private val disneyApi: IDisneyApi
): DisneyApiRepository {

    override suspend fun getCharacter(): List<DisneyData> {
        return disneyApi.getDisney().body()!!.data as List<DisneyData>
    }
}
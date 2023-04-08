package com.example.disneyapp.Data.remote.repository

import com.example.disneyapp.Model.DisneyData

interface DisneyApiRepository {
    suspend fun getCharacter() : List<DisneyData>

    suspend fun getOneCharacter(id : Int) : DisneyData
}
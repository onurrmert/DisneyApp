package com.example.disneyapp.Domain

import com.example.disneyapp.Data.remote.repository.DisneyApiRepository
import com.example.disneyapp.Data.remote.Model.DisneyData
import javax.inject.Inject

class ApiUseCase @Inject constructor(
    private val disneyApiRepository: DisneyApiRepository
) {
    suspend fun getChacracter() : List<DisneyData>{
        return disneyApiRepository.getCharacter()
    }

    suspend fun getOneCharacter(id : Int) : DisneyData? {
        return disneyApiRepository.getOneCharacter(id)
    }
}
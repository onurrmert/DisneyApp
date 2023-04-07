package com.example.disneyapp.Domain

import com.example.disneyapp.Data.remote.DisneyApiRepository
import com.example.disneyapp.Model.DisneyData
import javax.inject.Inject

class UseCase @Inject constructor(
    private val disneyRepository: DisneyApiRepository
) {
    suspend fun getDisneyModel() : List<DisneyData> {
        return disneyRepository.getCharacter()
    }
}
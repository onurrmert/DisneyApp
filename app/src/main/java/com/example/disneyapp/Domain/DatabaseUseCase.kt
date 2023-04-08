package com.example.disneyapp.Domain

import com.example.disneyapp.Data.local.Entity.DisneyEntity
import com.example.disneyapp.Data.local.Repository.DatabaseRepository
import javax.inject.Inject

class DatabaseUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    suspend fun insert(disneyEntity: DisneyEntity){
        databaseRepository.insert(disneyEntity)
    }

    suspend fun getAll() : List<DisneyEntity>{
        return databaseRepository.getAll()
    }

    suspend fun delete(id : Int){
        databaseRepository.delete(id)
    }

    suspend fun getOne(id : Int) : DisneyEntity{
        return databaseRepository.getOne(id)
    }
}
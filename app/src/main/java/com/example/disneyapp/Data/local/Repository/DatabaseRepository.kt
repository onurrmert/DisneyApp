package com.example.disneyapp.Data.local.Repository

import com.example.disneyapp.Data.local.Entity.DisneyEntity

interface DatabaseRepository {

    suspend fun insert(disneyEntity: DisneyEntity)

    suspend fun getAll() : List<DisneyEntity>

    suspend fun getOne(id : Int) : DisneyEntity

    suspend fun delete(id: Int)
}
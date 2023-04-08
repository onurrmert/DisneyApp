package com.example.disneyapp.Data.local.Repository

import com.example.disneyapp.Data.local.Dao.IDisneyDao
import com.example.disneyapp.Data.local.Entity.DisneyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DatabaseRepositoruImpl @Inject constructor(
    private val disneyDao: IDisneyDao
) : DatabaseRepository {

    override suspend fun insert(disneyEntity: DisneyEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            disneyDao.insert(disneyEntity)
        }
    }

    override suspend fun getAll(): List<DisneyEntity> {
        return disneyDao.getAllCharacter()
    }

    override suspend fun getOne(id : Int): DisneyEntity {
        return disneyDao.getOneCharacter(id)
    }

    override suspend fun delete(id: Int) {
        disneyDao.delete(id)
    }
}
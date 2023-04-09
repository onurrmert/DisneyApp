package com.example.disneyapp.Data.local.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.disneyapp.Data.local.Dao.IDisneyDao
import com.example.disneyapp.Data.local.Entity.DisneyEntity

@Database(entities = arrayOf(DisneyEntity::class), version = 1, exportSchema = false)
abstract class DisneyDatabase () : RoomDatabase(){
    abstract fun disneyDao() : IDisneyDao
}
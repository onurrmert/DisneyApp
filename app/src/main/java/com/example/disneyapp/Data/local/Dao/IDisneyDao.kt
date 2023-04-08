package com.example.disneyapp.Data.local.Dao

import androidx.annotation.NonNull
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.disneyapp.Data.local.Entity.DisneyEntity

@Dao
interface IDisneyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(disneyEntity: DisneyEntity)

    @Query("SELECT * FROM disneyTable")
    @NonNull
    suspend fun getAllCharacter() : List<DisneyEntity>

    @Query("SELECT * FROM disneyTable WHERE id = :id ")
    @NonNull
    suspend fun getOneCharacter(id : Int) : DisneyEntity

    @Query("DELETE FROM disneyTable WHERE id = :id")
    @NonNull
    suspend fun delete(id : Int)
}
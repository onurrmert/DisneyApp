package com.example.disneyapp.Data.local.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "disneyTable")
data class DisneyEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "_name")
    val name : String,
    @ColumnInfo(name = "_imageUrl")
    val imageUrl : String
){
    constructor(name: String, imageUrl: String) : this(0, name, imageUrl)
}

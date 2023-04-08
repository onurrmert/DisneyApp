package com.example.disneyapp.DI

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import com.example.disneyapp.Data.local.Dao.IDisneyDao
import com.example.disneyapp.Data.local.Database.DisneyDatabase
import com.example.disneyapp.Data.local.Repository.DatabaseRepositoruImpl
import com.example.disneyapp.Data.local.Repository.DatabaseRepository
import com.example.disneyapp.Data.remote.api.IDisneyApi
import com.example.disneyapp.Data.remote.repository.DisneyApiRepository
import com.example.disneyapp.Data.remote.repository.DisneyApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDisneyDaatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        DisneyDatabase::class.java,
        "disneyDB"
    ).build()

    @Singleton
    @Provides
    fun provideDieneyDao(disneyDatabase: DisneyDatabase) = disneyDatabase.disneyDao()

    @Singleton
    @Provides
    fun provideDisneyDatabaseRepository(disneyDao: IDisneyDao) : DatabaseRepository {
        return DatabaseRepositoruImpl(disneyDao)
    }
}
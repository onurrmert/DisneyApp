package com.example.disneyapp.DI

import com.example.disneyapp.Data.remote.repository.DisneyApiRepository
import com.example.disneyapp.Data.remote.repository.DisneyApiRepositoryImpl
import com.example.disneyapp.Data.remote.api.IDisneyApi
import com.example.disneyapp.Util.Constant.Companion.BaseUrl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun getRetrofit() : Retrofit {

        val client = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }

    @Singleton
    @Provides
    fun getDisneyApi() : IDisneyApi {
        return ApiModule().getRetrofit().create(IDisneyApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDisneyApiRepository(disneyApi: IDisneyApi) : DisneyApiRepository {
        return DisneyApiRepositoryImpl(disneyApi)
    }
}
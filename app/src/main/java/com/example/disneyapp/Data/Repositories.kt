package com.example.disneyapp.Data

import com.example.disneyapp.Remote.IDisneyApi
import javax.inject.Inject

class Repositories @Inject constructor(
    private val disneyApi: IDisneyApi
) {
    fun getDisneyApi() : IDisneyApi{
        return disneyApi
    }
}
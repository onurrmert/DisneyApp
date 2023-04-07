package com.example.disneyapp.UI.Main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyapp.Domain.ApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: ApiUseCase
) : ViewModel(){
    init {
        getDisney()
    }
    fun getDisney(){
        viewModelScope.launch {
            useCase.getChacracter().forEach {
                println(it.imageUrl)
            }
        }
    }
}
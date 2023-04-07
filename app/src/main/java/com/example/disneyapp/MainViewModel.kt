package com.example.disneyapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyapp.Domain.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel(){
    init {
        getDisney()
    }
    fun getDisney(){
        viewModelScope.launch {
            useCase.getDisneyModel().forEach {
                println(it.name)
            }
        }
    }
}
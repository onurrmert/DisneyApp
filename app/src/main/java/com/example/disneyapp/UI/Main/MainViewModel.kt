package com.example.disneyapp.UI.Main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyapp.Domain.ApiUseCase
import com.example.disneyapp.Model.DisneyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: ApiUseCase
) : ViewModel(){

    private val _disneyData = MutableLiveData<List<DisneyData>>()

    val disneyData : MutableLiveData<List<DisneyData>> get() = _disneyData

    init {
        getDisneyCharacters()
    }

    fun getDisneyCharacters(){
        viewModelScope.launch {
            try {
                _disneyData.value = useCase.getChacracter()
            }catch (e: Exception){
                Log.e("getDisneyCharacters error: " , e.localizedMessage!!)
            }
        }
    }
}
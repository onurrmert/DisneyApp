package com.example.disneyapp.UI.Detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyapp.Domain.ApiUseCase
import com.example.disneyapp.Data.remote.Model.DisneyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: ApiUseCase
) : ViewModel() {

    private val _disneyData = MutableLiveData<DisneyData>()

    val disneyData : MutableLiveData<DisneyData> get() = _disneyData

    fun getDisneyData(id : Int){
        viewModelScope.launch {
            _disneyData.value = useCase.getOneCharacter(id)
        }
    }
}
package com.example.disneyapp.UI.FavoriteDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyapp.Data.local.Entity.DisneyEntity
import com.example.disneyapp.Domain.DatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteDetailViewModel @Inject constructor(
    private val dataseUseCase: DatabaseUseCase
) : ViewModel() {

    private val _disneyEntity = MutableLiveData<DisneyEntity>()

    val disneyEntity : MutableLiveData<DisneyEntity> get() = _disneyEntity

    fun getData(id : Int){
        viewModelScope.launch {
            _disneyEntity.value = dataseUseCase.getOne(id)
        }
    }
}
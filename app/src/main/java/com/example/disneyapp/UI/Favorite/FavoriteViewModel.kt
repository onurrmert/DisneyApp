package com.example.disneyapp.UI.Favorite

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyapp.Data.local.Entity.DisneyEntity
import com.example.disneyapp.Data.local.Repository.DatabaseRepository
import com.example.disneyapp.Data.remote.Model.DisneyData
import com.example.disneyapp.Util.Extension.Companion.toast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val databaseRepository: DatabaseRepository
) : ViewModel() {

    private val _dataList = MutableLiveData<List<DisneyEntity>>()

    val dataList : MutableLiveData<List<DisneyEntity>> get() = _dataList

    fun getDataList(context: Context){
        viewModelScope.launch {
            if (databaseRepository.getAll().size > 0){
                _dataList.value = databaseRepository.getAll()
            }else{
                context.toast("No data found")
            }
        }
    }
}
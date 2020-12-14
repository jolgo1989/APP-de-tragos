package com.example.appdetragos.ui.viewmodel

import androidx.lifecycle.*
import com.example.appdetragos.domain.Repo
import com.example.appdetragos.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: Repo) : ViewModel() {

    private val tragosData = MutableLiveData<String>()

    fun setTragos(tragoName: String) {
        tragosData.value = tragoName
    }

    init {

        setTragos("margarita")
    }

    val fetchTragosList = tragosData.distinctUntilChanged().switchMap {nombreTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getTragosList(nombreTrago))

            } catch (e: Exception) {
                emit(Resource.Failure(e))

            }

        }
    }
}
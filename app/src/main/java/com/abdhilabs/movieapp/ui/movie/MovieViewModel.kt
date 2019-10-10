package com.abdhilabs.movieapp.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdhilabs.movieapp.data.repo.MainRepo
import com.abdhilabs.movieapp.model.MovieResponse

class MovieViewModel : ViewModel() {

    internal val dataList: MutableLiveData<MovieResponse> = MutableLiveData()
    internal val error: MutableLiveData<Throwable> = MutableLiveData()
    private val repository = MainRepo()

    fun getList() {
        repository.requestShow({
            dataList.postValue(it)
        }, {
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}
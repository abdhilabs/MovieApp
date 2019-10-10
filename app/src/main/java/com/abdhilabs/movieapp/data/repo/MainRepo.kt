package com.abdhilabs.movieapp.data.repo

import com.abdhilabs.movieapp.data.api.ServiceApi
import com.abdhilabs.movieapp.model.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepo {

    private val apiService = ServiceApi.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestShow(onResult: (MovieResponse) -> Unit, onError: (Throwable) -> Unit) {
        apiService.getMovieShowing()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<MovieResponse>(compositeDisposable) {
                override fun onApiSuccess(data: MovieResponse) {
                    onResult(data)
                }

                override fun onApiError(e: Throwable) {
                    onError(e)
                }
            })
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}
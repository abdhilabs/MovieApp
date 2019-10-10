package com.abdhilabs.movieapp.data.api

import com.abdhilabs.movieapp.BuildConfig
import com.abdhilabs.movieapp.model.MovieResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ServiceApi {

    fun create(): Api {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
        return retrofit.create(Api::class.java)
    }

    interface Api {
        @GET("movie/now_playing?api_key=" + BuildConfig.API_KEY + "&language=en-US")
        fun getMovieShowing(): Observable<MovieResponse>

        @GET("movie/upcoming?api_key=" + BuildConfig.API_KEY + "&language=en-US")
        fun getMovieSoon(): Observable<MovieResponse>
    }
}
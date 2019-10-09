package com.abdhilabs.movieapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MovieResponse(

    @Expose
    @SerializedName("results")
    var data: MutableList<MovieModel>
) {
    @Parcelize
    data class MovieModel(

        @Expose
        @SerializedName("title")
        var title: String,

        @Expose
        @SerializedName("release_date")
        var release: String,

        @Expose
        @SerializedName("overview")
        var overview: String,

        @Expose
        @SerializedName("poster_path")
        var poster: String,

        @Expose
        @SerializedName("backdrop_path")
        var backdrop: String,

        @Expose
        @SerializedName("vote_average")
        var vote: Number
    ) : Parcelable
}
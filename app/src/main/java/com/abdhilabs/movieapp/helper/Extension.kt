package com.abdhilabs.movieapp.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ViewGroup.inflate(resource: Int) =
    LayoutInflater.from(context).inflate(resource, this, false) as View

fun glideAdapter(context: View, path: String, source: ImageView) =
    Glide.with(context)
        .load("https://image.tmdb.org/t/p/w500$path")
        .fitCenter()
        .centerCrop()
        .into(source)
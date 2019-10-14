package com.abdhilabs.movieapp.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.movieapp.R
import com.abdhilabs.movieapp.helper.glideAdapter
import com.abdhilabs.movieapp.helper.inflate
import com.abdhilabs.movieapp.model.MovieResponse
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_soon.*

class SoonAdapter(private val movieSoon: MutableList<MovieResponse.MovieModel>) :
    RecyclerView.Adapter<SoonAdapter.SoonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoonViewHolder {
        return SoonViewHolder(parent.inflate(R.layout.item_soon))
    }

    override fun getItemCount(): Int = movieSoon.size

    override fun onBindViewHolder(holder: SoonViewHolder, position: Int) {
        holder.bind(movieSoon[position])
    }


    class SoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View?
            get() = itemView

        private val imgPoster = img_poster_soon as ImageView
        private val tvTitle = tv_title_soon as TextView

        fun bind(movie: MovieResponse.MovieModel) {
            val path = movie.poster
            glideAdapter(itemView, path, imgPoster)
            tvTitle.text = movie.title
        }
    }
}
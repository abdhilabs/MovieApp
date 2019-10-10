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
import kotlinx.android.synthetic.main.item_showing.*

class ShowingAdapter(private val movieShow: MutableList<MovieResponse.MovieModel>) :
    RecyclerView.Adapter<ShowingAdapter.ShowingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowingViewHolder {
        return ShowingViewHolder(parent.inflate(R.layout.item_showing))
    }

    override fun getItemCount(): Int = movieShow.size

    override fun onBindViewHolder(holder: ShowingViewHolder, position: Int) {
        holder.bind(movieShow[position])
    }

    class ShowingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View?
            get() = itemView

        private val imgPoster = img_poster_showing as ImageView
        private val tvTitle = tv_title_showing as TextView

        fun bind(movie: MovieResponse.MovieModel) {
            val path = movie.poster
            glideAdapter(itemView, path, imgPoster)
            tvTitle.text = movie.title
        }
    }
}
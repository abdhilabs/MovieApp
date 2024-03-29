package com.abdhilabs.movieapp.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.movieapp.R
import com.abdhilabs.movieapp.helper.inflate
import com.abdhilabs.movieapp.model.Group
import com.abdhilabs.movieapp.model.MovieResponse
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.group_item.*
import kotlinx.android.synthetic.main.item_showing.*
import kotlinx.android.synthetic.main.item_soon.view.*

class GroupAdapter(
    private val group: ArrayList<Group>
) : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {

    private var showing: MutableList<MovieResponse.MovieModel> = mutableListOf()
    private var soon: MutableList<MovieResponse.MovieModel> = mutableListOf()

    fun setShowing(list: MutableList<MovieResponse.MovieModel>) {
        this.showing = list
    }

    fun setSoon(list: MutableList<MovieResponse.MovieModel>) {
        this.soon = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(parent.inflate(R.layout.group_item))
    }

    override fun getItemCount(): Int = group.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        setGroupTitle(holder.groupTitle, group[position].groupTitle)
        setList(holder.groupRv, position)
    }

    private fun setGroupTitle(groupTitle: TextView, text: String) {
        groupTitle.text = text
    }

    private fun setList(groupRv: RecyclerView, position: Int) {
        when (position) {
            0 -> setShowingList(groupRv)
            1 -> setSoonList(groupRv)
        }
    }

    private fun setShowingList(groupRv: RecyclerView) {
        val showingAdapter = ShowingAdapter(showing)
        groupRv.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = showingAdapter
            isNestedScrollingEnabled = true
        }
    }

    private fun setSoonList(groupRv: RecyclerView) {
        val soonAdapter = SoonAdapter(soon)
        groupRv.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = soonAdapter
            isNestedScrollingEnabled = true
        }
    }

    class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View?
            get() = itemView
        val groupTitle = tv_group_title as TextView
        val groupRv = rv_group_movie as RecyclerView
    }
}
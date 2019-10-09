package com.abdhilabs.movieapp.data

import com.abdhilabs.movieapp.model.Group

class GroupItem {
    companion object{
        val list : List<Group>
        get() = mutableListOf(
            Group("Now Showing","View All"),
            Group("Coming Soon","View All"),
            Group("Article","View All")
        )
    }
}
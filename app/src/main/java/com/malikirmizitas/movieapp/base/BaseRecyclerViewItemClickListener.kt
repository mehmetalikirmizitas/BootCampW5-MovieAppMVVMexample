package com.malikirmizitas.movieapp.base

import androidx.annotation.IdRes

interface BaseRecyclerItemClickListener<T> {
    fun onItemClicked(clickedObject: T, @IdRes id: Int = 0)
}
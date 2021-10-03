package com.malikirmizitas.movieapp.base

import com.malikirmizitas.movieapp.R

interface IBaseFragment {
    /**
     * We mark ShouldCheckInternetConnection as false cause of we need to call this function where we need it.
     */
    fun shouldCheckInternetConnection() = false
    fun getStatusBarColor() = R.color.white
    fun networkConnection(): Boolean
}
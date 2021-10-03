package com.malikirmizitas.movieapp.base

import com.malikirmizitas.movieapp.R

interface IBaseFragment {
    fun shouldCheckInternetConnection() = false
    fun getStatusBarColor() = R.color.white
    fun networkConnection() : Boolean
}
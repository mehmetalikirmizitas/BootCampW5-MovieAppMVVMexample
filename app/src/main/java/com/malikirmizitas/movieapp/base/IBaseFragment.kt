package com.malikirmizitas.movieapp.base

import com.malikirmizitas.movieapp.R

interface IBaseFragment {
    fun shouldCheckInternetConnection() = true
    fun getStatusBarColor() = R.color.white
}
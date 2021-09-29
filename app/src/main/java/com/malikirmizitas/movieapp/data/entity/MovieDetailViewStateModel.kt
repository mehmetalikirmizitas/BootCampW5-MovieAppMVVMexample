package com.malikirmizitas.movieapp.data.entity

import com.malikirmizitas.movieapp.data.entity.detail.Movie

class MovieDetailViewStateModel(private val detail : Movie) {

    fun getDetail() : Movie = detail
}
package com.malikirmizitas.movieapp.ui.movie

import com.malikirmizitas.movieapp.data.entity.Movies
import com.malikirmizitas.movieapp.data.entity.Result

class MovieStateModel(val movies: Movies) {

    fun getList(): List<Result> = movies.results
}
package com.malikirmizitas.movieapp.ui.movie

import com.malikirmizitas.movieapp.data.entity.MovieResult
import com.malikirmizitas.movieapp.data.entity.Movies

class MovieStateModel(val movies: Movies) {

    fun getList(): List<MovieResult> = movies.movieResults
}
package com.malikirmizitas.movieapp.ui.movie

import com.malikirmizitas.movieapp.data.entity.movies.MovieResult
import com.malikirmizitas.movieapp.data.entity.movies.MoviesResponse

class MovieStateModel(val moviesResponse: MoviesResponse) {

    fun getList(): List<MovieResult> = moviesResponse.movieResults
}
package com.malikirmizitas.movieapp.data.entity

class MovieStateModel(val movies: Movies) {

    fun getList(): List<Result> = movies.results
}
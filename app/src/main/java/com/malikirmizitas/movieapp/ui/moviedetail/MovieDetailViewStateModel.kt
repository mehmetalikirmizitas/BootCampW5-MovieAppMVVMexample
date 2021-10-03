package com.malikirmizitas.movieapp.ui.moviedetail

import com.malikirmizitas.movieapp.data.entity.detail.MovieDetails

/**
 * this class is another bridge between model and view
 */

class MovieDetailViewStateModel(private val detail: MovieDetails) {

    fun getDetail(): MovieDetails = detail
    fun isAdult(): String {
        return if (detail.adult)
            "PG-13"
        else
            "PG-18"
    }
}
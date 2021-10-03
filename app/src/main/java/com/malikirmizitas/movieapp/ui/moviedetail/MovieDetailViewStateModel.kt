package com.malikirmizitas.movieapp.ui.moviedetail

import com.malikirmizitas.movieapp.data.entity.detail.Movie

/**
 * this class is another bridge between model and view
 */

class MovieDetailViewStateModel(private val detail: Movie) {

    fun getDetail(): Movie = detail
    fun isAdult(): String {
        return if (detail.adult)
            "PG-13"
        else
            "PG-18"
    }
}
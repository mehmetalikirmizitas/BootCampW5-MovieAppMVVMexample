package com.malikirmizitas.movieapp.ui.moviedetail

import android.app.Application
import com.malikirmizitas.movieapp.data.entity.detail.Movie
import com.malikirmizitas.movieapp.ui.favourites.FavouritesMovieViewModel

/**
 * this class is another bridge between model and view
 */

class MovieDetailViewStateModel(private val detail : Movie) {

    fun getDetail() : Movie = detail
    fun isAdult() : String{
        return if (detail.adult)
            "PG-13"
        else
            "PG-18"
    }
    fun isFavourite() : Boolean = detail.isInFavourite
}
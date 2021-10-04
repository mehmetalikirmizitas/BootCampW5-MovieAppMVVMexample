package com.malikirmizitas.movieapp.ui.favourites

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.malikirmizitas.movieapp.data.entity.movies.MovieRoom
import com.malikirmizitas.movieapp.data.local.RoomDB

class FavouritesMovieViewModel : ViewModel() {

    var allFavourites: ArrayList<MovieRoom> = ArrayList()

    fun getAllFavourites(context: Context) {
        val favouritesDao = RoomDB.getMovieDatabase(context)?.favouritesDao()
        allFavourites = favouritesDao?.getFavourites() as ArrayList<MovieRoom>
    }

}
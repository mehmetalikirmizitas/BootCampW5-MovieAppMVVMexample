package com.malikirmizitas.movieapp.ui.moviedetail

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.malikirmizitas.movieapp.data.ApiRepository
import com.malikirmizitas.movieapp.data.entity.MovieRoom
import com.malikirmizitas.movieapp.data.local.RoomDB

class MovieDetailViewModel(movieId: Int) : ViewModel() {

    val details = MediatorLiveData<MovieDetailViewStateModel>()
    private val apiRepository = ApiRepository()


    /**
     * This function is one of bridge between api and view
     * Sending detail's values to view
     */
    init {
        apiRepository.getMovieDetailById(movieId)
        details.addSource(apiRepository.onDetailFetched) {
            details.value = MovieDetailViewStateModel(it)
        }
    }

    fun addFavourites(favouriteMovie: MovieRoom, context: Context) {
        val favouriteDao = RoomDB.getMovieDatabase(context)?.favouritesDao()
        favouriteDao?.addFavourites(favouriteMovie)
    }
}
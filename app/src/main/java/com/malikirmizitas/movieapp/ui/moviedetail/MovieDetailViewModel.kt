package com.malikirmizitas.movieapp.ui.moviedetail

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.malikirmizitas.movieapp.data.ApiRepository
import com.malikirmizitas.movieapp.data.entity.movies.MovieRoom
import com.malikirmizitas.movieapp.data.local.RoomDB

class MovieDetailViewModel(private val context: Context, private val movieId: Int) : ViewModel() {

    val details = MediatorLiveData<MovieDetailViewStateModel>()
    private val apiRepository = ApiRepository()
    private var allFavourites: ArrayList<MovieRoom> = ArrayList()
    var isInFavourite = MediatorLiveData<Boolean>()

    /**
     * This function is one of bridge between api and view
     * Sending detail's values to view
     */
    init {
        getAllFavourites()
        apiRepository.getMovieDetailById(movieId)
        details.addSource(apiRepository.onDetailFetched) {
            details.value = MovieDetailViewStateModel(it)
            loopForIsInFavourite()
        }
    }

    private fun loopForIsInFavourite() {
        if (allFavourites.size > 0) {
            for (i in allFavourites) {
                if (i.secondaryId == details.value!!.getDetail().id) {
                    isInFavourite.value = true
                    break
                } else
                    isInFavourite.value = false
            }
        }
        /**
         * when favourites list is empty return false
         */
        else
            isInFavourite.value = false
    }

    fun addFavourites() {
        val item = MovieRoom(
            0,
            details.value!!.getDetail().posterPath,
            details.value!!.getDetail().title,
            details.value!!.getDetail().voteAverage,
            movieId,
        )
        val favouriteDao = RoomDB.getMovieDatabase(context)?.favouritesDao()
        favouriteDao?.addFavourites(item)

    }

    fun deleteFavourite() {
        val favouriteDao = RoomDB.getMovieDatabase(context)?.favouritesDao()
        favouriteDao?.deleteFavourites(loopForDelete())
        getAllFavourites()
    }

    private fun loopForDelete(): MovieRoom? {
        var favouriteMovie: MovieRoom? = null
        for (i in allFavourites) {
            if (i.secondaryId == movieId) {
                favouriteMovie = i
                break
            }
        }
        return favouriteMovie
    }

    private fun getAllFavourites() {
        val favouritesDao = RoomDB.getMovieDatabase(context)?.favouritesDao()
        allFavourites = favouritesDao?.getFavourites() as ArrayList<MovieRoom>
    }
}
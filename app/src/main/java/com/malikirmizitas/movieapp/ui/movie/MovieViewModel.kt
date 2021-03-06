package com.malikirmizitas.movieapp.ui.movie

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.malikirmizitas.movieapp.data.ApiRepository

class MovieViewModel : ViewModel() {

    private var page = 1
    val movies = MediatorLiveData<MovieStateModel>()
    private val apiRepository = ApiRepository()

    init {
        apiRepository.getAllMovies(page)
        movies.addSource(apiRepository.onMoviesFetched) {
            movies.value = MovieStateModel(it)
        }
    }

    fun getMoviesWithPagination() {
        apiRepository.getAllMovies(++page)
    }
}
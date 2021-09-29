package com.malikirmizitas.movieapp.ui.movie

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.malikirmizitas.movieapp.data.ApiRepository
import com.malikirmizitas.movieapp.data.entity.MovieStateModel

class MovieViewModel : ViewModel() {

    private val lang = "en-US"
    private val page = 1
    val movies = MediatorLiveData<MovieStateModel>()
    private val apiRepository = ApiRepository()

    init {
        apiRepository.getAllMovies(lang, page)
        movies.addSource(apiRepository.onMoviesFetched) {
            movies.value = MovieStateModel(it)
        }
    }
}
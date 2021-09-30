package com.malikirmizitas.movieapp.ui.moviedetail

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.malikirmizitas.movieapp.data.ApiRepository

class MovieDetailViewModel : ViewModel() {

    val details = MediatorLiveData<MovieDetailViewStateModel>()
    private val apiRepository = ApiRepository()


    /**
     * This function is one of bridge between api and view
     * Sending detail's values to view
     */
    fun getDetail(id: Int) {
        apiRepository.getMovieDetailById(id)
        details.addSource(apiRepository.onDetailFetched) {
            details.value = MovieDetailViewStateModel(it)
        }
    }
}
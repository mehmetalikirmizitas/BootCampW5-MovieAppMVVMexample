package com.malikirmizitas.movieapp.ui.moviedetail

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.malikirmizitas.movieapp.data.ApiRepository
import com.malikirmizitas.movieapp.data.entity.MovieDetailViewStateModel

class MovieDetailViewModel : ViewModel() {

    val details = MediatorLiveData<MovieDetailViewStateModel>()
    private val apiRepository = ApiRepository()

    fun getDetail(id: Int) {
        apiRepository.getMovieDetailById(id)
        details.addSource(apiRepository.onDetailFetched) {
            details.value = MovieDetailViewStateModel(it)
        }
    }
}
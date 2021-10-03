package com.malikirmizitas.movieapp.data

import androidx.lifecycle.MutableLiveData
import com.malikirmizitas.movieapp.base.BaseCallBack
import com.malikirmizitas.movieapp.data.entity.movies.MoviesResponse
import com.malikirmizitas.movieapp.data.entity.detail.MovieDetails
import com.malikirmizitas.movieapp.data.remote.ServiceConnector
import com.malikirmizitas.movieapp.utils.API_KEY
import com.malikirmizitas.movieapp.utils.LANGUAGE

class ApiRepository {

    val onMoviesFetched = MutableLiveData<MoviesResponse>()
    val onDetailFetched = MutableLiveData<MovieDetails>()

    fun getAllMovies(page: Int) {
        ServiceConnector.restInterface.getPopularMovies(API_KEY, LANGUAGE, page)
            .enqueue(object : BaseCallBack<MoviesResponse>() {
                override fun onSuccess(data: MoviesResponse) {
                    onMoviesFetched.postValue(data)
                }
            })
    }

    fun getMovieDetailById(movie_id: Int) {
        ServiceConnector.restInterface.getMovieDetailById(movie_id, API_KEY, LANGUAGE)
            .enqueue(object : BaseCallBack<MovieDetails>() {
                override fun onSuccess(data: MovieDetails) {
                    onDetailFetched.postValue(data)
                }
            })
    }
}
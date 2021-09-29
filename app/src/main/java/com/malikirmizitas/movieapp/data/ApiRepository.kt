package com.malikirmizitas.movieapp.data

import androidx.lifecycle.MutableLiveData
import com.malikirmizitas.movieapp.base.BaseCallBack
import com.malikirmizitas.movieapp.data.entity.Movies
import com.malikirmizitas.movieapp.data.entity.Result
import com.malikirmizitas.movieapp.data.entity.detail.Movie
import com.malikirmizitas.movieapp.data.remote.ServiceConnector

class ApiRepository {

    val onMoviesFetched = MutableLiveData<Movies>()
    val onDetailFetched =  MutableLiveData<Movie>()

    fun getAllMovies(lang: String,page : Int) {

        ServiceConnector.restInterface.getPopularMovies(lang,page)
            .enqueue(object : BaseCallBack<Movies>() {
                override fun onSuccess(data: Movies) {
                    onMoviesFetched.postValue(data)
                }
            })
    }
    fun getMovieDetailById(movie_id : Int){
        ServiceConnector.restInterface.getMovieDetailById(movie_id)
            .enqueue(object : BaseCallBack<Movie>() {
                override fun onSuccess(data: Movie) {
                    onDetailFetched.postValue(data)
                }
            })
    }
}
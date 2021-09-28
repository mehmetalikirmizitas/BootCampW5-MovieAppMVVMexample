package com.malikirmizitas.movieapp.data.remote

import com.malikirmizitas.movieapp.data.entity.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("popular?api_key=19801890c22cf584aea27870231318a5")
    fun getPopularMovies(
        @Query("language") lang: String,
        @Query("page") page: Int
    ): Call<Movies>
}
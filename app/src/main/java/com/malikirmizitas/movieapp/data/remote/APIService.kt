package com.malikirmizitas.movieapp.data.remote

import com.malikirmizitas.movieapp.data.entity.movies.MoviesResponse
import com.malikirmizitas.movieapp.data.entity.detail.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("popular")
    fun getPopularMovies(
        @Query("api_key") apiKey : String,
        @Query("language") lang: String,
        @Query("page") page: Int
    ): Call<MoviesResponse>

    @GET("{movie_id}")
    fun getMovieDetailById(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") lang: String
    ): Call<MovieDetails>
}
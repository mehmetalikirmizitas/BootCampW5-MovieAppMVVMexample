package com.malikirmizitas.movieapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.malikirmizitas.movieapp.data.entity.movies.MovieRoom

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM favourites ORDER BY id DESC")
    fun getFavourites() : List<MovieRoom>

    @Insert
    fun addFavourites(favouriteMovie : MovieRoom?)

    @Delete
    fun deleteFavourites(favouriteMovie: MovieRoom?)
}
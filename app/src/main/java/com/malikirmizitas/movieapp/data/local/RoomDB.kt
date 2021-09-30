package com.malikirmizitas.movieapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.malikirmizitas.movieapp.data.entity.MovieRoom
import com.malikirmizitas.movieapp.data.entity.detail.Movie


@Database(entities = [MovieRoom::class], version = 1)
abstract class RoomDB : RoomDatabase() {

    abstract fun favouritesDao(): FavouritesDao?

    companion object {
        private var INSTANCE: RoomDB? = null

        @TypeConverters
        fun getMovieDatabase(context: Context): RoomDB? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<RoomDB>(
                    context.applicationContext,
                    RoomDB::class.java,
                    "MovieDB"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }
}
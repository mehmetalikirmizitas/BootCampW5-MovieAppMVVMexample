package com.malikirmizitas.movieapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourites")
data class MovieRoom(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @SerializedName("poster_path")
    @ColumnInfo(name = "posterPath") val posterPath: String,
    @SerializedName("title")
    @ColumnInfo(name = "title") val title: String,
    @SerializedName("vote_average")
    @ColumnInfo(name = "voteAverage") val voteAverage: Double,
    @SerializedName("id")
    @ColumnInfo(name = "secondaryId") val secondaryId: Int
)
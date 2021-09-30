package com.malikirmizitas.movieapp.data.entity.detail


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourites")
data class Movie(
    @SerializedName("adult")
    @ColumnInfo(name = "adult") val adult: Boolean,
    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdropPath") val backdropPath: String,
    @SerializedName("belongs_to_collection")
    @ColumnInfo(name = "belongsToCollection") val belongsToCollection: BelongsToCollection,
    @SerializedName("budget")
    @ColumnInfo(name = "budget") val budget: Int,
    @SerializedName("genres")
    @ColumnInfo(name = "genres") val genres: List<Genre>,
    @SerializedName("homepage")
    @ColumnInfo(name = "homepage") val homepage: String,
    @SerializedName("id")
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @SerializedName("imdb_id")
    @ColumnInfo(name = "imdbId")  val imdbId: String,
    @SerializedName("original_language")
    @ColumnInfo(name = "originalLanguage") val originalLanguage: String,
    @SerializedName("original_title")
    @ColumnInfo(name = "originalTitle") val originalTitle: String,
    @SerializedName("overview")
    @ColumnInfo(name = "overview") val overview: String,
    @SerializedName("popularity")
    @ColumnInfo(name = "popularity") val popularity: Double,
    @SerializedName("poster_path")
    @ColumnInfo(name = "posterPath") val posterPath: String,
    @SerializedName("production_companies")
    @ColumnInfo(name = "productionCompanies")  val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    @ColumnInfo(name = "productionCountries") val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    @ColumnInfo(name = "releaseDate") val releaseDate: String,
    @SerializedName("revenue")
    @ColumnInfo(name = "revenue") val revenue: Int,
    @SerializedName("runtime")
    @ColumnInfo(name = "runtime") val runtime: Int,
    @SerializedName("spoken_languages")
    @ColumnInfo(name = "spokenLanguages") val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    @ColumnInfo(name = "status") val status: String,
    @SerializedName("tagline")
    @ColumnInfo(name = "tagline") val tagline: String,
    @SerializedName("title")
    @ColumnInfo(name = "title") val title: String,
    @SerializedName("video")
    @ColumnInfo(name = "video") val video: Boolean,
    @SerializedName("vote_average")
    @ColumnInfo(name = "voteAverage") val voteAverage: Double,
    @SerializedName("vote_count")
    @ColumnInfo(name = "voteCount") val voteCount: Int
)
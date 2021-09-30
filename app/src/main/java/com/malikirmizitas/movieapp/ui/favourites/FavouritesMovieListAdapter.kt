package com.malikirmizitas.movieapp.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.data.entity.MovieRoom
import com.malikirmizitas.movieapp.databinding.FavouriteMoviesRecyclerViewItemBinding

class FavouritesMovieListAdapter(private val favouritesMoviesList : ArrayList<MovieRoom>) : RecyclerView.Adapter<FavouritesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        return FavouritesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.favourite_movies_recycler_view_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val favouriteMovie = this.favouritesMoviesList[position]

        holder.init(favouriteMovie)
    }

    override fun getItemCount(): Int = this.favouritesMoviesList.size
}

class FavouritesViewHolder(private val binding: FavouriteMoviesRecyclerViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun init(favouriteMovie: MovieRoom) {
        binding.favouriteMovie = favouriteMovie
    }

}

package com.malikirmizitas.movieapp.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseRecyclerItemClickListener
import com.malikirmizitas.movieapp.data.entity.MovieRoom
import com.malikirmizitas.movieapp.databinding.FavouriteMoviesRecyclerViewItemBinding

class FavouritesMovieListAdapter(private val favouritesMoviesList: ArrayList<MovieRoom>) :
    RecyclerView.Adapter<FavouritesViewHolder>() {

    private var itemClickListener: BaseRecyclerItemClickListener<MovieRoom>? = null

    constructor(
        favouritesMoviesList: ArrayList<MovieRoom>,
        itemClickListener: BaseRecyclerItemClickListener<MovieRoom>
    ) : this(favouritesMoviesList) {
        this.itemClickListener = itemClickListener
    }

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
        holder.setOnClickListener(favouriteMovie, this.itemClickListener)
    }

    override fun getItemCount(): Int = this.favouritesMoviesList.size
}

class FavouritesViewHolder(private val binding: FavouriteMoviesRecyclerViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun init(favouriteMovie: MovieRoom) {
        binding.favouriteMovie = favouriteMovie
    }

    fun setOnClickListener(
        favouriteMovie: MovieRoom,
        itemClickListener: BaseRecyclerItemClickListener<MovieRoom>?
    ) {
        binding.root.setOnClickListener {
            itemClickListener?.onItemClicked(favouriteMovie,it.id)
        }
    }
}

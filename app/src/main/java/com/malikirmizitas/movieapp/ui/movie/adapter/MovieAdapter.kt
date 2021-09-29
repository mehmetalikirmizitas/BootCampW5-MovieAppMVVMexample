package com.malikirmizitas.movieapp.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.data.entity.Result
import com.malikirmizitas.movieapp.databinding.MovieRecyclerViewItemBinding
import com.malikirmizitas.movieapp.ui.tablayout.TabLayoutControllerFragmentDirections


class MovieAdapter(private val movieList: List<Result>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_recycler_view_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = this.movieList[position]

        holder.populate(movie)
    }

    override fun getItemCount() = this.movieList.size

    inner class MovieViewHolder(private val binding: MovieRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun populate(movie: Result) {
            binding.movies = movie
            binding.executePendingBindings()

            binding.movieCardView.setOnClickListener {
                val action =
                    TabLayoutControllerFragmentDirections.actionTabLayoutControllerFragmentToMovieDetailFragment(
                        movie.id
                    )
                it.findNavController().navigate(action)
            }
        }
    }
}
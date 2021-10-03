package com.malikirmizitas.movieapp.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseRecyclerItemClickListener
import com.malikirmizitas.movieapp.data.entity.MovieResult
import com.malikirmizitas.movieapp.databinding.MovieRecyclerViewItemBinding


class MovieAdapter(private val movieList: ArrayList<MovieResult>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemClickListener: BaseRecyclerItemClickListener<MovieResult>? = null

    constructor(
        movieList: ArrayList<MovieResult>,
        itemClickListener: BaseRecyclerItemClickListener<MovieResult>
    ) : this(movieList) {
        this.itemClickListener = itemClickListener
    }

    companion object {
        private const val MOVIE = 1
        private const val LOADING = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == MOVIE) {
            MovieViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.movie_recycler_view_item,
                    parent,
                    false
                )
            )
        } else {
            ProgressBarViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.recycler_view_progress_bar,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = this.movieList[position]
        if (movieList[position].viewType == MOVIE) {
            holder as MovieViewHolder
            holder.x(movie)
            holder.setOnClickListener(movie, this.itemClickListener!!)
        }
    }

    override fun getItemViewType(position: Int) = this.movieList[position].viewType

    override fun getItemCount() = this.movieList.size

    inner class MovieViewHolder(private val binding: MovieRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun x(movie: MovieResult) {
            binding.movies = movie
            binding.executePendingBindings()
        }

        fun setOnClickListener(
            movie: MovieResult,
            itemClickListener: BaseRecyclerItemClickListener<MovieResult>
        ) {
            binding.root.setOnClickListener {
                itemClickListener.onItemClicked(movie, it.id)
            }
        }
    }

    inner class ProgressBarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

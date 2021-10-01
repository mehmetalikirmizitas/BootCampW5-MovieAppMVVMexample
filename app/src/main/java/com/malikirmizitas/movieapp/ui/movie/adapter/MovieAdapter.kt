package com.malikirmizitas.movieapp.ui.movie.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseRecyclerItemClickListener
import com.malikirmizitas.movieapp.data.entity.Result
import com.malikirmizitas.movieapp.databinding.MovieRecyclerViewItemBinding
import com.malikirmizitas.movieapp.databinding.RecyclerViewProgressBarBinding


class MovieAdapter(private val movieList: List<Result>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemClickListener: BaseRecyclerItemClickListener<Result>? = null

    constructor(
        movieList: List<Result>,
        itemClickListener: BaseRecyclerItemClickListener<Result>
    ) : this(movieList) {
        this.itemClickListener = itemClickListener
    }

    companion object {
        private const val MOVIE = 1
        private const val LOADING = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        Log.e("ViewType:", viewType.toString())
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
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
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
        fun x(movie: Result) {
            binding.movies = movie
            binding.executePendingBindings()
        }

        fun setOnClickListener(
            movie: Result,
            itemClickListener: BaseRecyclerItemClickListener<Result>
        ) {
            binding.root.setOnClickListener {
                itemClickListener.onItemClicked(movie, it.id)
            }
        }
    }

    inner class ProgressBarViewHolder(binding: RecyclerViewProgressBarBinding) :
        RecyclerView.ViewHolder(binding.root)
}
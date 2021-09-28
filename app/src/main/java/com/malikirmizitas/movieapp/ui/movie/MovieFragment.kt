package com.malikirmizitas.movieapp.ui.movie

import androidx.lifecycle.ViewModelProvider
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.databinding.FragmentMovieBinding
import com.malikirmizitas.movieapp.ui.movie.adapter.MovieAdapter

class MovieFragment : BaseFragment<MovieViewModel, FragmentMovieBinding>() {
    override var viewModel: MovieViewModel? = null


    override fun getLayoutID(): Int = R.layout.fragment_movie

    override fun observeLiveData() {
        viewModel?.movies?.observe(this, {
            dataBinding.movies = it
            dataBinding.executePendingBindings()
            dataBinding.moviesRecyclerView.adapter = MovieAdapter(it.getList())
        })
    }

    override fun prepareView() {
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
    }
}
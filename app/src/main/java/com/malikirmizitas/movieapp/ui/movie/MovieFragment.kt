package com.malikirmizitas.movieapp.ui.movie

import androidx.lifecycle.ViewModelProvider
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.databinding.FragmentMovieBinding

class MovieFragment : BaseFragment<MovieViewModel, FragmentMovieBinding>() {
    override var viewModel: MovieViewModel? = null


    override fun getLayoutID(): Int = R.layout.fragment_movie

    override fun observeLiveData() {
        viewModel?.movies?.observe(this, {
            dataBinding.movies = it
            dataBinding.executePendingBindings()
        })
    }

    override fun prepareView() {
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
    }
}
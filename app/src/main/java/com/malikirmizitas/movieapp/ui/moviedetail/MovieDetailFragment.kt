package com.malikirmizitas.movieapp.ui.moviedetail

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>() {
    override var viewModel: MovieDetailViewModel? = null

    private var adapter: MovieDetailCategoryAdapter = MovieDetailCategoryAdapter()

    override fun getLayoutID() = R.layout.fragment_movie_detail

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun observeLiveData() {
        viewModel?.getDetail(args.movieId)

        viewModel?.details?.observe(this, {
            dataBinding.movie = it
            dataBinding.executePendingBindings()

            Log.e("Titiz",it.getDetail().genres.size.toString())
            adapter.setCategories(it.getDetail().genres)
            dataBinding.detailCategoryRecyclerView.adapter = adapter
        })
    }

    override fun prepareView() {
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
    }
}
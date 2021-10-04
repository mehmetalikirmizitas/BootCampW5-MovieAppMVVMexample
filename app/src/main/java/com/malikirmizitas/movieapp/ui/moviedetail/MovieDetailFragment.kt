package com.malikirmizitas.movieapp.ui.moviedetail

import androidx.lifecycle.ViewModelProvider
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.databinding.FragmentMovieDetailBinding
import com.malikirmizitas.movieapp.utils.gone
import com.malikirmizitas.movieapp.utils.toastLong
import com.malikirmizitas.movieapp.utils.toastShort
import com.malikirmizitas.movieapp.utils.visible

class MovieDetailFragment : BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>() {
    override var viewModel: MovieDetailViewModel? = null

    private var adapter: MovieDetailCategoryAdapter = MovieDetailCategoryAdapter()

    override fun getLayoutID() = R.layout.fragment_movie_detail

    override fun observeLiveData() {

        viewModel?.details?.observe(this, {
            dataBinding.movie = it
            dataBinding.executePendingBindings()
            adapter.setCategories(it.getDetail().genres)

            initView()
        })
    }

    override fun networkConnection(): Boolean {
        return super.networkConnection()
    }

    private fun initView() {

        viewModel?.isInFavourite?.observe(this, {
            if (it) {
                dataBinding.addFavouriteImageView.setImageResource(R.drawable.ic_full_heart)
                dataBinding.removeFavouriteButton.visible()
            }
        })
    }

    override fun prepareView() {

        if (!networkConnection()) {
            dataBinding.noConnectionImageView.visible()
            dataBinding.noConnectionTextView.visible()
            dataBinding.detailScreenParentLayout.gone()
        }
        dataBinding.detailCategoryRecyclerView.adapter = adapter

        onClickListeners()
    }

    private fun onClickListeners() {
        dataBinding.removeFavouriteButton.setOnClickListener {
            removeFavourite()
        }
        dataBinding.addFavouriteImageView.setOnClickListener {
            addFavourite()
        }
    }


    private fun removeFavourite() {
        viewModel?.isInFavourite?.observe(this, {
            if (it) {
                viewModel?.deleteFavourite()
                toastShort("Movie is successfully removed from favourites")
                dataBinding.addFavouriteImageView.setImageResource(R.drawable.ic_empty_heart)
                dataBinding.removeFavouriteButton.gone()
            }

        })
    }

    private fun addFavourite() {
        viewModel?.isInFavourite?.observe(this, {
            if (it) {
                toastLong("This movie is already in favourite")
            } else {
                viewModel?.addFavourites()
                toastShort("Successfully added in favourites")
                dataBinding.addFavouriteImageView.setImageResource(R.drawable.ic_full_heart)
                dataBinding.addFavouriteImageView.isClickable = false
                dataBinding.removeFavouriteButton.visible()
            }
        })
    }


    override fun prepareViewModel() {
        viewModel = ViewModelProvider(
            this,
            viewModelFactory {
                MovieDetailViewModel(
                    requireContext(),
                    arguments?.getInt("movieId")!!
                )
            }
        ).get(MovieDetailViewModel::class.java)
    }

    override fun shouldCheckInternetConnection() = true
}
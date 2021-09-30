package com.malikirmizitas.movieapp.ui.favourites

import androidx.lifecycle.ViewModelProvider
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.databinding.FragmentFavouritesBinding

class FavouritesFragment : BaseFragment<FavouritesMovieViewModel, FragmentFavouritesBinding>() {

    override var viewModel: FavouritesMovieViewModel? = null

    override fun getLayoutID() = R.layout.fragment_favourites

    override fun observeLiveData() {
        viewModel?.getAllFavourites(requireContext())
    }

    override fun prepareView() {
        dataBinding.FavouriteMoviesRecyclerView.adapter =
            FavouritesMovieListAdapter(viewModel?.allFavourites!!)
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(FavouritesMovieViewModel::class.java)
    }
}
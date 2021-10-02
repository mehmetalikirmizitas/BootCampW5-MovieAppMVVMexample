package com.malikirmizitas.movieapp.ui.favourites

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.databinding.FragmentFavouritesBinding

class FavouritesFragment : BaseFragment<FavouritesMovieViewModel, FragmentFavouritesBinding>() {

    override var viewModel: FavouritesMovieViewModel? = null

    override fun getLayoutID() = R.layout.fragment_favourites

    override fun observeLiveData() {
        Log.e("size is : ","${viewModel?.allFavourites?.size}")
        viewModel?.getAllFavourites(requireContext())
        dataBinding.FavouriteMoviesRecyclerView.adapter =
            FavouritesMovieListAdapter(viewModel?.allFavourites!!)
    }

    override fun prepareView() {

    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(FavouritesMovieViewModel::class.java)
    }
}
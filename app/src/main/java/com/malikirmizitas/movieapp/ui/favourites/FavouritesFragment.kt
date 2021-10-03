package com.malikirmizitas.movieapp.ui.favourites

import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.base.BaseRecyclerItemClickListener
import com.malikirmizitas.movieapp.data.entity.MovieRoom
import com.malikirmizitas.movieapp.databinding.FragmentFavouritesBinding

class FavouritesFragment : BaseFragment<FavouritesMovieViewModel, FragmentFavouritesBinding>() {

    override var viewModel: FavouritesMovieViewModel? = null

    private var adapter: FavouritesMovieListAdapter? = null
    private var favouriteList: ArrayList<MovieRoom> = arrayListOf()

    override fun getLayoutID() = R.layout.fragment_favourites

    override fun observeLiveData() {

    }

    override fun prepareView() {
        viewModel?.getAllFavourites(requireContext())
        favouriteList = viewModel?.allFavourites as ArrayList<MovieRoom>

        adapter = FavouritesMovieListAdapter(favouriteList,
            object : BaseRecyclerItemClickListener<MovieRoom> {
                override fun onItemClicked(clickedObject: MovieRoom, id: Int) {
                    val bundle = bundleOf("movieId" to clickedObject.secondaryId)
                    Log.e("clicked ", clickedObject.title)
                    findNavController().navigate(
                        R.id.action_tabLayoutControllerFragment_to_movieDetailFragment, bundle
                    )
                }
            })
        dataBinding.FavouriteMoviesRecyclerView.adapter = adapter

    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(FavouritesMovieViewModel::class.java)
    }
}
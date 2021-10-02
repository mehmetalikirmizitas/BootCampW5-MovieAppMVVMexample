package com.malikirmizitas.movieapp.ui.moviedetail

import androidx.lifecycle.ViewModelProvider
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.data.entity.MovieRoom
import com.malikirmizitas.movieapp.databinding.FragmentMovieDetailBinding
import com.malikirmizitas.movieapp.ui.favourites.FavouritesMovieViewModel
import com.malikirmizitas.movieapp.utils.toastLong
import com.malikirmizitas.movieapp.utils.toastShort

class MovieDetailFragment : BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>() {
    override var viewModel: MovieDetailViewModel? = null
    var favouritesViewModel: FavouritesMovieViewModel? = null

    private var adapter: MovieDetailCategoryAdapter = MovieDetailCategoryAdapter()

    override fun getLayoutID() = R.layout.fragment_movie_detail

    override fun observeLiveData() {

        viewModel?.details?.observe(this, {
            dataBinding.movie = it
            dataBinding.executePendingBindings()
            adapter.setCategories(it.getDetail().genres)
            initView(it)
            dataBinding.addFavouriteImageView.setOnClickListener { _ ->
                favouritesViewModel?.getAllFavourites(requireContext())
                addFavourite(it)
            }
        })
    }

    private fun addFavourite(it: MovieDetailViewStateModel) {
        var isNotInFavourites = true
        val favouriteMovies = favouritesViewModel?.allFavourites!!
        for (i in favouriteMovies) {
            if (i.secondaryId == it.getDetail().id) {
                isNotInFavourites = false
                break
            }
        }
        if (isNotInFavourites) {
            val newFavouriteMovie = MovieRoom(
                0,
                it.getDetail().posterPath,
                it.getDetail().title,
                it.getDetail().voteAverage,
                it.getDetail().id
            )
            viewModel?.addFavourites(newFavouriteMovie, requireContext())
            toastShort("Successfully added in favourites")
            dataBinding.addFavouriteImageView.setImageResource(R.drawable.ic_down_arrow)
        } else
            toastLong("This movie is already in favourite")
        it.getDetail().isInFavourite = true
    }

    override fun prepareView() {
        dataBinding.detailCategoryRecyclerView.adapter = adapter
    }

    private fun initView(it: MovieDetailViewStateModel) {
        favouritesViewModel?.getAllFavourites(requireContext())
        val favouritesMovie = favouritesViewModel?.allFavourites

        for (i in favouritesMovie!!) {
            if (i.secondaryId == it.getDetail().id) {
                dataBinding.addFavouriteImageView.setImageResource(R.drawable.ic_full_heart)
                break
            }
        }
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(
            this,
            viewModelFactory { MovieDetailViewModel(arguments?.getInt("movieId")!!) }
        ).get(MovieDetailViewModel::class.java)

        favouritesViewModel = ViewModelProvider(this).get(FavouritesMovieViewModel::class.java)
    }
}
package com.malikirmizitas.movieapp.ui.movie

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.base.BaseRecyclerItemClickListener
import com.malikirmizitas.movieapp.data.entity.Result
import com.malikirmizitas.movieapp.databinding.FragmentMovieBinding
import com.malikirmizitas.movieapp.ui.movie.adapter.MovieAdapter

class MovieFragment : BaseFragment<MovieViewModel, FragmentMovieBinding>() {
    override var viewModel: MovieViewModel? = null

    override fun getLayoutID(): Int = R.layout.fragment_movie

    override fun observeLiveData() {
        viewModel?.movies?.observe(this, {
            dataBinding.movies = it
            dataBinding.executePendingBindings()
            dataBinding.moviesRecyclerView.adapter =
                MovieAdapter(it.getList(), object : BaseRecyclerItemClickListener<Result> {
                    override fun onItemClicked(clickedObject: Result, id: Int) {
                        val bundle = bundleOf("movieId" to clickedObject.id)
                        findNavController().navigate(R.id.action_tabLayoutControllerFragment_to_movieDetailFragment,bundle)
                    }
                })
        })
    }

    override fun prepareView() {

        /*dataBinding.moviesRecyclerView.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (dataBinding.moviesRecyclerView.canScrollVertically(1) &&
                    newState == RecyclerView.SCROLL_STATE_IDLE &&
                        )
            }
        })
        val result = Result()*/
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
    }

}
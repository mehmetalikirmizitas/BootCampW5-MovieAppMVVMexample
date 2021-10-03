package com.malikirmizitas.movieapp.ui.movie

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malikirmizitas.movieapp.R
import com.malikirmizitas.movieapp.base.BaseFragment
import com.malikirmizitas.movieapp.base.BaseRecyclerItemClickListener
import com.malikirmizitas.movieapp.data.entity.Result
import com.malikirmizitas.movieapp.databinding.FragmentMovieBinding
import com.malikirmizitas.movieapp.utils.gone
import com.malikirmizitas.movieapp.utils.visible

class MovieFragment : BaseFragment<MovieViewModel, FragmentMovieBinding>() {

    override fun getLayoutID(): Int = R.layout.fragment_movie

    private var movieList: ArrayList<Result> = arrayListOf()
    override var viewModel: MovieViewModel? = null
    private var adapter: MovieAdapter? = null
    private var range = 0
    private val result = Result()

    override fun observeLiveData() {
        viewModel?.movies?.observe(this, {
            dataBinding.movies = it
            dataBinding.executePendingBindings()
            if (movieList.contains(result)) {
                movieList.removeAt(movieList.size - 1)
            }
            movieList.addAll(it.getList())
            adapter?.notifyItemRangeChanged(range, movieList.size)
            range += it.getList().size
        })
    }

    override fun networkConnection(): Boolean {
        return super.networkConnection()
    }

    override fun prepareView() {
        if (!networkConnection()) {
            dataBinding.noConnectionImageView.visible()
            dataBinding.noConnectionTextView.visible()
            dataBinding.noConnectionButton.visible()
            dataBinding.moviesRecyclerView.gone()
            dataBinding.noConnectionButton.setOnClickListener {
                findNavController().navigate(R.id.action_tabLayoutControllerFragment_self)
            }
        } else {
            dataBinding.noConnectionImageView.gone()
            dataBinding.noConnectionTextView.gone()
            dataBinding.noConnectionButton.gone()
            dataBinding.moviesRecyclerView.visible()
        }

        val layoutManager = GridLayoutManager(requireContext(), 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (movieList[position].viewType == 1) {
                    1
                } else
                    2
            }
        }
        dataBinding.moviesRecyclerView.layoutManager = layoutManager

        adapter = MovieAdapter(movieList, object : BaseRecyclerItemClickListener<Result> {
            override fun onItemClicked(clickedObject: Result, id: Int) {
                val bundle = bundleOf("movieId" to clickedObject.id)
                findNavController().navigate(
                    R.id.action_tabLayoutControllerFragment_to_movieDetailFragment, bundle
                )
            }
        })

        dataBinding.moviesRecyclerView.adapter = adapter

        dataBinding.moviesRecyclerView.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!dataBinding.moviesRecyclerView.canScrollVertically(1) &&
                    newState == RecyclerView.SCROLL_STATE_IDLE
                    && !movieList.contains(result)
                ) {
                    result.viewType = 2
                    movieList.add(result)
                    adapter!!.notifyItemInserted(movieList.size - 1)
                    dataBinding.moviesRecyclerView.scrollToPosition(movieList.size - 1)
                    viewModel?.getMoviesWithPagination()
                }
            }
        })
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    override fun shouldCheckInternetConnection() = true

}
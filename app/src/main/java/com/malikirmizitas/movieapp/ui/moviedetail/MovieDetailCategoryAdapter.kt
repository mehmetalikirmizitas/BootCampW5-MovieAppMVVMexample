package com.malikirmizitas.movieapp.ui.moviedetail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malikirmizitas.movieapp.data.entity.detail.Genre
import com.malikirmizitas.movieapp.databinding.MovieDetailCategoryRecyclerItemBinding

/**
 * this class help us to binding category list to movie detail
 */

class MovieDetailCategoryAdapter() :
    RecyclerView.Adapter<MovieDetailCategoryAdapter.CategoryViewHolder>() {
    private var categories: List<Genre> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val binding = MovieDetailCategoryRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]

        holder.init(category)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCategories(categories: List<Genre>) {
        this.categories = categories
        notifyDataSetChanged()
    }

    override fun getItemCount() = categories.size

    inner class CategoryViewHolder(val binding: MovieDetailCategoryRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun init(category : Genre) {
            binding.category = category
        }
    }
}



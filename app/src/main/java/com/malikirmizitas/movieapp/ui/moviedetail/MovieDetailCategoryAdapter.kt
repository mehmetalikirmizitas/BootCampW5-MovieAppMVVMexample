package com.malikirmizitas.movieapp.ui.moviedetail

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malikirmizitas.movieapp.data.entity.detail.Genre
import com.malikirmizitas.movieapp.databinding.MovieDetailCategoryRecyclerItemBinding

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

        holder.binding.categoryName.text = category.name
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCategories(categories: List<Genre>) {
        this.categories = categories
        notifyDataSetChanged()
    }

    override fun getItemCount() = categories.size

    inner class CategoryViewHolder(val binding: MovieDetailCategoryRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}



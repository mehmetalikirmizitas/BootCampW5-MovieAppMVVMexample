package com.malikirmizitas.movieapp.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.malikirmizitas.movieapp.R

object ImageBindingAdapter{

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setUrl(imageView: AppCompatImageView,imageUrl : String?){
        Glide.with(imageView.context)
            .load("https://image.tmdb.org/t/p/w500${imageUrl}")
            .error(R.drawable.image_not_found)
            .placeholder(R.drawable.image_not_found)
            .into(imageView)
    }
}
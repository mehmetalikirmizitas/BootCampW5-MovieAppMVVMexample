package com.malikirmizitas.movieapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.malikirmizitas.movieapp.databinding.ActivityMainBinding
import com.malikirmizitas.movieapp.ui.movie.MovieFragment
import com.malikirmizitas.movieapp.ui.tablayout.TabLayoutAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
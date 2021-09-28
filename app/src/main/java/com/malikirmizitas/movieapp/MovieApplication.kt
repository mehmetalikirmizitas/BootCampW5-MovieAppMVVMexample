package com.malikirmizitas.movieapp

import android.app.Application
import com.malikirmizitas.movieapp.data.remote.ServiceConnector

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init()
    }
}
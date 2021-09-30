package com.malikirmizitas.movieapp

import android.app.Application
import com.malikirmizitas.movieapp.data.remote.ServiceConnector

/**
 * Calling Service connector's main function for communication with api
 *
 * This class using on Manifest.xml
 */
class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init()
    }
}
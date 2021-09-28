package com.malikirmizitas.movieapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceConnector {

    companion object {

        private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

        private var retrofit: Retrofit? = null
        lateinit var restInterface: APIService

        fun init() {

            //logging interceptor
            val logging = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }

            //adding logging interceptor to okhttp
            val httpClient: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            //creating retrofit client to correspond with BackEnd Service
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()


            restInterface = retrofit?.create<APIService>(APIService::class.java)!!
        }
    }
}
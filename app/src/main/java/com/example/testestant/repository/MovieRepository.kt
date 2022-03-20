package com.example.testestant.repository

import com.example.testestant.model.MoviesService
import com.example.testestant.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {

    private var service: MoviesService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(MoviesService::class.java)
    }

    suspend fun listMovies() = service.getPopularMovies()
    }
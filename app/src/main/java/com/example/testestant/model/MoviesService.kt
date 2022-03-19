package com.example.testestant.model

import com.example.testestant.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("/movie/popular")
    fun getPopularMovies(
        @Query("api_Key") apiKey: String = API_KEY
    ) : Call<MoviesPopular>

    @GET("/movie/{movie_id}")
    fun getMovies(): Call<MoviesApiResults>
}
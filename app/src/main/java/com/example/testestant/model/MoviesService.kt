package com.example.testestant.model

import com.example.testestant.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ) : Response<MoviesPopular>

    @GET("movie/{movieId}")
    suspend fun getMovie(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey: String = API_KEY
    ): Response<MoviesApiResults>
}
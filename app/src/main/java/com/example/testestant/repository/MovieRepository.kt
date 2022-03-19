package com.example.testestant.repository

import android.util.Log
import com.example.testestant.model.MoviesApiResults
import com.example.testestant.model.MoviesService
import com.example.testestant.utils.Constants.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {

    private val service: MoviesService = TODO()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MoviesService::class.java)
    }

    fun listMovies() {
       val call = service.getMovies()

       call.enqueue(object : Callback<MoviesApiResults> {
            override fun onFailure(call: Call<MoviesApiResults>, t: Throwable) {
              Log.e("POPULAR_MOVIES_API", "Error loading popular movies list.", t)
            }

            override fun onResponse(call: Call<MoviesApiResults>,
                                    response: Response<MoviesApiResults>
            ){
                Log.d("POPULAR_MOVIE_API", response.toString())
            }
        })
    }
}



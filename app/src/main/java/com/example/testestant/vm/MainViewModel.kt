package com.example.testestant.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testestant.model.MoviesApiResults
import com.example.testestant.model.MoviesPopular
import com.example.testestant.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MovieRepository): ViewModel() {

    val movieList = MutableLiveData<List<MoviesApiResults>>()

    suspend fun getAllMovies() {

        val request = repository.listMovies()
        if ( request.isSuccessful ) {
            movieList.value = request.body()!!.popularMovie
        }
        else {
            Log.e("***Teste", request.errorBody()?.string().toString())
        }
    }
}

class ViewModelFactory constructor(private val repository: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>)
            : T =
        MainViewModel(repository) as T
}
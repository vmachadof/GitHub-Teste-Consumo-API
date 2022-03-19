package com.example.testestant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.testestant.dependency.AppModule
import com.example.testestant.model.MoviesService
import com.example.testestant.vm.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = AppModule.createNetworkService<MoviesService>()

        lifecycleScope.launch {
            val movies = service.getPopularMovies()
            Log.d("Rogue", movies.toString())
        }
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


    }
}
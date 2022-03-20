package com.example.testestant

import AdapterMovies
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.testestant.databinding.ActivityMainBinding
import com.example.testestant.dependency.AppModule
import com.example.testestant.repository.MovieRepository
import com.example.testestant.vm.MainViewModel
import com.example.testestant.vm.ViewModelFactory
import kotlinx.coroutines.launch
import com.example.testestant.model.MoviesService as MoviesService1

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MovieRepository()
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        setupObservers()

        lifecycleScope.launch {
            viewModel.getAllMovies()
        }
    }

    private fun setupObservers() {
        viewModel.movieList.observe (this) {
            Log.d("***Teste", it.toString())
        }
    }
}
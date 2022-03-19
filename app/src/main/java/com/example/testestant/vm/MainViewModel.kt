package com.example.testestant.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mMovieApi = MutableLiveData<String>()
    val movieApi = mMovieApi
}
package com.example.testestant.model

import com.google.gson.annotations.SerializedName

data class MoviesPopular(
    @SerializedName("results")
    val popularMovie: List<Items>
)

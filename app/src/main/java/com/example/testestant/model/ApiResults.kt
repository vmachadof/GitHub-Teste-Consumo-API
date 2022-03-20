package com.example.testestant.model

import com.google.gson.annotations.SerializedName

data class MoviesApiResults(
    @SerializedName("backdrop_path")val backdrop_path: String,
    @SerializedName("title")val title: String,
    @SerializedName("genre")val genre: String,
    @SerializedName("year")val year: String,
    @SerializedName("overview")val overview: String,
    @SerializedName("language")val language: String)
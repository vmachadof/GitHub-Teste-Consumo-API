package com.example.testestant.model

data class Items(
    val backdrop_path: String,
    val title: String,
    val genre: String,
    val year: String,
)

data class MoviesApiResults(
    val backdrop_path: String,
    val title: String,
    val genre: String,
    val year: String,
    val overview: String,
    val language: String
)


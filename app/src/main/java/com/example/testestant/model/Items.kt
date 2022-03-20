package com.example.testestant.model

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("title")val title: String,
    @SerializedName("genre")val genre: String,
    @SerializedName("year")val year: String,
)



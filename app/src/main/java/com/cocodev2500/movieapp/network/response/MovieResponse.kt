package com.cocodev2500.movieapp.network.response

import com.cocodev2500.movieapp.models.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    var resultados: List<MovieModel>
)

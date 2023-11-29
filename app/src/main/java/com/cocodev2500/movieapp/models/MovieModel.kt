package com.cocodev2500.movieapp.models

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("original_title")
    var nombrePelicula: String,
    @SerializedName("overview")
    var Descripcion: String,
    @SerializedName("poster_path")
    var poster: String,
    @SerializedName("release_date")
    var fechaLanzamiento: String,
    @SerializedName("vote_average")
    var votoPromedio: String,
    @SerializedName("vote_count")
    var totalVotos: String,

)

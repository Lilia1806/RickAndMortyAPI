package com.example.rickandmortyapi.models

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(

    @SerializedName("results")
    val results: List<T>
)

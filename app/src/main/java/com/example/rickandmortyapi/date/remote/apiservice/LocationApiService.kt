package com.example.rickandmortyapi.date.remote.apiservice

import com.example.rickandmortyapi.models.LocationModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchLocation(
    ): RickAndMortyResponse<LocationModel>
}
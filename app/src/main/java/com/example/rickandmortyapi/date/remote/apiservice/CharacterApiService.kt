package com.example.rickandmortyapi.date.remote.apiservice

import com.example.rickandmortyapi.models.CharacterModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacter(
    ): RickAndMortyResponse<CharacterModel>
}
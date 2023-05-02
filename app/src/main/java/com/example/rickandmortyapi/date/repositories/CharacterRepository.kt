package com.example.rickandmortyapi.date.repositories

import com.example.rickandmortyapi.date.remote.apiservice.CharacterApiService
import com.example.rickandmortyapi.models.CharacterModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import com.example.rickandmortyapi.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApiService: CharacterApiService
) {
    fun fetchCharacter(): Flow<Resource< RickAndMortyResponse<CharacterModel>>> = flow {
        emit(Resource.Loading())
        val fetchCharacter = characterApiService.fetchCharacter()
        emit(Resource.Success(fetchCharacter))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.localizedMessage ?: "Error!", null))
    }
}
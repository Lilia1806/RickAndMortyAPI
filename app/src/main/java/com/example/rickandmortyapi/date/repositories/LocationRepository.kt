package com.example.rickandmortyapi.date.repositories

import com.example.rickandmortyapi.date.remote.apiservice.LocationApiService
import com.example.rickandmortyapi.models.LocationModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import com.example.rickandmortyapi.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LocationRepository  @Inject constructor(
    private val locationApiService: LocationApiService
){
    fun fetchLocation(): Flow<Resource<RickAndMortyResponse<LocationModel>>> = flow {
        emit(Resource.Loading())
        val fetchLocation = locationApiService.fetchLocation()
        emit(Resource.Success(fetchLocation))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.localizedMessage ?: "Error!", null))
    }
}
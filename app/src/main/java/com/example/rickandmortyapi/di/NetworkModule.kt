package com.example.rickandmortyapi.di

import com.example.rickandmortyapi.date.remote.RetrofitClient
import com.example.rickandmortyapi.date.remote.apiservice.CharacterApiService
import com.example.rickandmortyapi.date.remote.apiservice.LocationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun fetchLocation() = retrofitClient.provideLocationApiService()

    @Singleton
    @Provides
    fun fetchCharacter() =  retrofitClient.provideCharacterApiService()
}
package com.example.rickandmortyapi.models

import com.example.rickandmortyapi.base.IBaseDiffModel

data class RickAndMortyModel(
    val character: CharacterModel,
    val location: LocationModel,
    override val id: Int = 0,
) : IBaseDiffModel

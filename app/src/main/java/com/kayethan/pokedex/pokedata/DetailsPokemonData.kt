package com.kayethan.pokedex.pokedata

data class DetailsPokemonData(
    val height: Float,
    val weight: Float,
    val pokemonType: Int,
    val descriptionText: Int,
    val levelingRate: LevelingRate
)
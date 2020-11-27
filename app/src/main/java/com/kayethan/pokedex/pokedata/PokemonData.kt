package com.kayethan.pokedex.pokedata

data class PokemonData(
    val basicPokemonData: BasicPokemonData,
    val detailsPokemonData: DetailsPokemonData,
    val gameLocations: List<GameLocation>
) {
}
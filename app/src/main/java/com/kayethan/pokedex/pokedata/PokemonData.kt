package com.kayethan.pokedex.pokedata

data class PokemonData(
    val basicPokemonData: BasicPokemonData,
    val detailsPokemonData: DetailsPokemonData,
    val galleryPokemonData: GalleryPokemonData,
    val gameLocations: List<GameLocation>
) {
}
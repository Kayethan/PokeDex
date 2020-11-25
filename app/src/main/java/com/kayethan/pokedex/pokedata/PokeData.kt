package com.kayethan.pokedex.pokedata

import com.kayethan.pokedex.pokelist.PokemonEntry

data class PokeData(
        val name: String,
        val number: Int,
        val type1: PokeType,
        val type2: PokeType?,
        val icon: Int
) {
    fun toPokemonEntry(): PokemonEntry {
        return PokemonEntry(icon, name, number, type1, type2)
    }
}
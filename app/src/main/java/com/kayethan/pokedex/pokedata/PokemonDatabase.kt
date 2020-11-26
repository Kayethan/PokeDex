package com.kayethan.pokedex.pokedata

import com.kayethan.pokedex.R

object PokemonDatabase {
    const val POKEMON_KEY = "POKEMON_KEY"

    private val pokemons = listOf<PokeData>(
        PokeData(
            "Bulbasaur",
            1,
            PokeType.Grass,
            PokeType.Poison,
            R.drawable.poke001
        ),
        PokeData(
            "Ivysaur",
            2,
            PokeType.Grass,
            PokeType.Poison,
            R.drawable.poke002
        ),
        PokeData(
            "Venusaur",
            3,
            PokeType.Grass,
            PokeType.Poison,
            R.drawable.poke003
        )
    )

    fun getPokemonList(): List<PokeData> {
        return pokemons
    }

    fun getPokemonByNumber(number: Int): PokeData? {
        return pokemons.find { x: PokeData -> x.number == number }
    }
}
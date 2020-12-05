package com.kayethan.pokedex.pokedata

import com.kayethan.pokedex.R

object PokemonDatabase {
    const val POKEMON_KEY = "POKEMON_KEY"

    private val pokemons = listOf<PokemonData>(
        PokemonData(
            BasicPokemonData(
                "Bulbasaur",
                1,
                PokeType.Grass,
                PokeType.Poison,
                R.drawable.poke001
            ),
            DetailsPokemonData(
                0.7f,
                6.9f,
                R.string.seed_pokemon,
                R.string.desc_001,
                LevelingRate.MediumSlow
            ),
            GalleryPokemonData(
                listOf<Int>(
                    R.drawable.temp_1,
                    R.drawable.temp_2,
                    R.drawable.temp_3,
                    R.drawable.temp_4,
                    R.drawable.temp_5,
                    R.drawable.temp_6,
                )
            ),
            listOf<GameLocation>(
                    GameLocation(Route.ProfessorOak, IntRange(5, 5)),
                    GameLocation(Route.Route001, IntRange(2, 5))
            )
        )
    )

    fun getPokemonList(): List<PokemonData> {
        return pokemons
    }

    fun getPokemonByNumber(number: Int): PokemonData? {
        return pokemons.find { x: PokemonData -> x.basicPokemonData.number == number }
    }
}
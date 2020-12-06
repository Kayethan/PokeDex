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
                            R.string.seed_category,
                            R.string.desc_001,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_1,
                                    R.drawable.temp_3,
                                    R.drawable.temp_5
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.ProfessorOak, IntRange(5, 5))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Ivysaur",
                            2,
                            PokeType.Grass,
                            PokeType.Poison,
                            R.drawable.poke002
                    ),
                    DetailsPokemonData(
                            1.0f,
                            13.0f,
                            R.string.seed_category,
                            R.string.desc_002,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_5,
                                    R.drawable.temp_2,
                                    R.drawable.temp_3,
                                    R.drawable.temp_6
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(16, 16))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Venusaur",
                            3,
                            PokeType.Grass,
                            PokeType.Poison,
                            R.drawable.poke003
                    ),
                    DetailsPokemonData(
                            2.0f,
                            100.0f,
                            R.string.seed_category,
                            R.string.desc_003,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_4,
                                    R.drawable.temp_1,
                                    R.drawable.temp_2,
                                    R.drawable.temp_5,
                                    R.drawable.temp_3
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(32, 32))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Charmander",
                            4,
                            PokeType.Fire,
                            null,
                            R.drawable.poke004
                    ),
                    DetailsPokemonData(
                            0.6f,
                            8.5f,
                            R.string.lizard_category,
                            R.string.desc_004,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_6,
                                    R.drawable.temp_2,
                                    R.drawable.temp_3
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.ProfessorOak, IntRange(5, 5))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Charmeleon",
                            5,
                            PokeType.Fire,
                            null,
                            R.drawable.poke005
                    ),
                    DetailsPokemonData(
                            1.1f,
                            19.0f,
                            R.string.flame_category,
                            R.string.desc_005,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_4,
                                    R.drawable.temp_5,
                                    R.drawable.temp_1,
                                    R.drawable.temp_3
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(16, 16))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Charizard",
                            6,
                            PokeType.Fire,
                            PokeType.Flying,
                            R.drawable.poke006
                    ),
                    DetailsPokemonData(
                            1.7f,
                            90.5f,
                            R.string.flame_category,
                            R.string.desc_006,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_6,
                                    R.drawable.temp_2,
                                    R.drawable.temp_4,
                                    R.drawable.temp_5,
                                    R.drawable.temp_3
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(36, 36))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Squirtle",
                            7,
                            PokeType.Water,
                            null,
                            R.drawable.poke007
                    ),
                    DetailsPokemonData(
                            0.5f,
                            9.0f,
                            R.string.tiny_turtle_category,
                            R.string.desc_007,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_2,
                                    R.drawable.temp_4,
                                    R.drawable.temp_3
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.ProfessorOak, IntRange(5, 5))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Wartortle",
                            8,
                            PokeType.Water,
                            null,
                            R.drawable.poke008
                    ),
                    DetailsPokemonData(
                            1.0f,
                            22.5f,
                            R.string.turtle_category,
                            R.string.desc_008,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_5,
                                    R.drawable.temp_4,
                                    R.drawable.temp_3,
                                    R.drawable.temp_2
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(16, 16))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Blastoise",
                            9,
                            PokeType.Water,
                            null,
                            R.drawable.poke009
                    ),
                    DetailsPokemonData(
                            1.6f,
                            85.5f,
                            R.string.shellfish_category,
                            R.string.desc_009,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_1,
                                    R.drawable.temp_2,
                                    R.drawable.temp_3,
                                    R.drawable.temp_4,
                                    R.drawable.temp_5
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(36, 36))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Caterpie",
                            10,
                            PokeType.Bug,
                            null,
                            R.drawable.poke010
                    ),
                    DetailsPokemonData(
                            0.3f,
                            2.9f,
                            R.string.worm_category,
                            R.string.desc_010,
                            LevelingRate.MediumFast
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_2,
                                    R.drawable.temp_4
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Route002, IntRange(4, 5)),
                            GameLocation(Route.Route024, IntRange(7, 7)),
                            GameLocation(Route.Route025, IntRange(8, 8)),
                            GameLocation(Route.ViridianForest, IntRange(3, 5)),
                            GameLocation(Route.PatternBush, IntRange(6, 6))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Metapod",
                            11,
                            PokeType.Bug,
                            null,
                            R.drawable.poke011
                    ),
                    DetailsPokemonData(
                            0.7f,
                            9.9f,
                            R.string.cocoon_category,
                            R.string.desc_011,
                            LevelingRate.MediumFast
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_3,
                                    R.drawable.temp_4,
                                    R.drawable.temp_1,
                                    R.drawable.temp_2,
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(7, 7)),
                            GameLocation(Route.Route024, IntRange(8, 8)),
                            GameLocation(Route.Route025, IntRange(9, 9)),
                            GameLocation(Route.ViridianForest, IntRange(4, 6)),
                            GameLocation(Route.PatternBush, IntRange(9, 9))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Butterfree",
                            12,
                            PokeType.Bug,
                            PokeType.Flying,
                            R.drawable.poke012
                    ),
                    DetailsPokemonData(
                            1.1f,
                            32.0f,
                            R.string.butterfly_category,
                            R.string.desc_012,
                            LevelingRate.MediumFast
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_4,
                                    R.drawable.temp_1,
                                    R.drawable.temp_2,
                                    R.drawable.temp_6,
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(10, 10))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Weedle",
                            13,
                            PokeType.Bug,
                            PokeType.Poison,
                            R.drawable.poke013
                    ),
                    DetailsPokemonData(
                            0.3f,
                            3.2f,
                            R.string.hairy_bug_category,
                            R.string.desc_013,
                            LevelingRate.MediumFast
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_1,
                                    R.drawable.temp_3
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Route002, IntRange(4, 5)),
                            GameLocation(Route.Route024, IntRange(7, 7)),
                            GameLocation(Route.Route025, IntRange(8, 8)),
                            GameLocation(Route.ViridianForest, IntRange(3, 5)),
                            GameLocation(Route.PatternBush, IntRange(6, 6))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Kakuna",
                            14,
                            PokeType.Bug,
                            PokeType.Poison,
                            R.drawable.poke014
                    ),
                    DetailsPokemonData(
                            0.6f,
                            10.0f,
                            R.string.cocoon_category,
                            R.string.desc_014,
                            LevelingRate.MediumFast
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_5,
                                    R.drawable.temp_6,
                                    R.drawable.temp_3,
                                    R.drawable.temp_1,
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(7, 7)),
                            GameLocation(Route.Route024, IntRange(8, 8)),
                            GameLocation(Route.Route025, IntRange(9, 9)),
                            GameLocation(Route.ViridianForest, IntRange(4, 6)),
                            GameLocation(Route.PatternBush, IntRange(9, 9))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Beedrill",
                            15,
                            PokeType.Bug,
                            PokeType.Poison,
                            R.drawable.poke015
                    ),
                    DetailsPokemonData(
                            1.0f,
                            29.5f,
                            R.string.poison_bee_category,
                            R.string.desc_015,
                            LevelingRate.MediumFast
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_2,
                                    R.drawable.temp_1,
                                    R.drawable.temp_4,
                                    R.drawable.temp_6,
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(10, 10))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Pidgey",
                            16,
                            PokeType.Normal,
                            PokeType.Flying,
                            R.drawable.poke016
                    ),
                    DetailsPokemonData(
                            0.3f,
                            1.8f,
                            R.string.tiny_bird_category,
                            R.string.desc_016,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_3,
                                    R.drawable.temp_1,
                                    R.drawable.temp_2
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Route001, IntRange(2, 5)),
                            GameLocation(Route.Route002, IntRange(2, 5)),
                            GameLocation(Route.Route003, IntRange(6, 7)),
                            GameLocation(Route.Route005, IntRange(13, 16)),
                            GameLocation(Route.Route006, IntRange(13, 16)),
                            GameLocation(Route.Route007, IntRange(19, 22)),
                            GameLocation(Route.Route008, IntRange(18, 20)),
                            GameLocation(Route.Route012, IntRange(23, 27)),
                            GameLocation(Route.Route013, IntRange(25, 27)),
                            GameLocation(Route.Route014, IntRange(27, 27)),
                            GameLocation(Route.Route015, IntRange(25, 27)),
                            GameLocation(Route.Route024, IntRange(11, 13)),
                            GameLocation(Route.Route025, IntRange(11, 13)),
                            GameLocation(Route.BondBridge, IntRange(29, 32)),
                            GameLocation(Route.BerryForest, IntRange(32, 32)),
                            GameLocation(Route.FiveIsleMeadow, IntRange(44, 44))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Pidgeotto",
                            17,
                            PokeType.Normal,
                            PokeType.Flying,
                            R.drawable.poke017
                    ),
                    DetailsPokemonData(
                            1.1f,
                            30.0f,
                            R.string.bird_category,
                            R.string.desc_017,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_4,
                                    R.drawable.temp_3,
                                    R.drawable.temp_1,
                                    R.drawable.temp_2
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(18, 18)),
                            GameLocation(Route.Route013, IntRange(29, 29)),
                            GameLocation(Route.Route014, IntRange(29, 29)),
                            GameLocation(Route.Route015, IntRange(29, 29)),
                            GameLocation(Route.BondBridge, IntRange(34, 40)),
                            GameLocation(Route.BerryForest, IntRange(37, 37)),
                            GameLocation(Route.FiveIsleMeadow, IntRange(48, 50))
                    )
            ),
            PokemonData(
                    BasicPokemonData(
                            "Pidgeot",
                            18,
                            PokeType.Normal,
                            PokeType.Flying,
                            R.drawable.poke018
                    ),
                    DetailsPokemonData(
                            1.5f,
                            39.5f,
                            R.string.bird_category,
                            R.string.desc_018,
                            LevelingRate.MediumSlow
                    ),
                    GalleryPokemonData(
                            listOf<Int>(
                                    R.drawable.temp_5,
                                    R.drawable.temp_6,
                                    R.drawable.temp_3,
                                    R.drawable.temp_1,
                                    R.drawable.temp_4
                            )
                    ),
                    listOf<GameLocation>(
                            GameLocation(Route.Evolution, IntRange(36, 36))
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
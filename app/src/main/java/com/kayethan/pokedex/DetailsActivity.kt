package com.kayethan.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kayethan.pokedex.databinding.ActivityDetailsBinding
import com.kayethan.pokedex.pokedata.PokeData
import com.kayethan.pokedex.pokedata.PokemonDatabase
import java.lang.Exception

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    var pokemonNumber: Int = -1
    lateinit var pokemonData: PokeData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionBar = supportActionBar


        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonNumber = intent.getIntExtra(PokemonDatabase.POKEMON_KEY, -1)

        if (pokemonNumber == -1) {
            throw Exception("INVALID VALUE")
        }

        // TODO CHANGE
        pokemonData = PokemonDatabase.getPokemonByNumber(pokemonNumber)!!

        actionBar!!.title = "${pokemonData.name} - #" + pokemonData.number.toString().padStart(3, '0')
    }
}
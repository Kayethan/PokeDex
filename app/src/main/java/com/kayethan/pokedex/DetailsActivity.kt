package com.kayethan.pokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.kayethan.pokedex.databinding.ActivityDetailsBinding
import com.kayethan.pokedex.pokedata.PokeData
import com.kayethan.pokedex.pokedata.PokemonData
import com.kayethan.pokedex.pokedata.PokemonDatabase
import com.kayethan.pokedex.pokedetails.DescriptionFragment
import com.kayethan.pokedex.pokedetails.DetailsAdapter
import com.kayethan.pokedex.pokedetails.LocationsFragment
import com.kayethan.pokedex.pokedetails.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.activity_details.*
import java.lang.Exception

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    var pokemonNumber: Int = -1
//    lateinit var pokemonData: PokemonData

    companion object {
        lateinit var pokemonData: PokemonData
        const val NUM_PAGES = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tabNames = listOf<String>(
            getString(R.string.description),
            getString(R.string.locations),
            getString(R.string.gallery)
        )

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonNumber = intent.getIntExtra(PokemonDatabase.POKEMON_KEY, -1)

        if (pokemonNumber == -1) {
            throw Exception("INVALID VALUE")
        }

        pokemonData = PokemonDatabase.getPokemonByNumber(pokemonNumber)!!

        val actionBar = supportActionBar
        actionBar!!.title = "${pokemonData.basicPokemonData.name} - #" + pokemonData.basicPokemonData.number.toString().padStart(3, '0')

        val pagerAdapter = DetailsAdapter(this, pokemonData)
        viewPager.adapter = pagerAdapter

        viewPager.setPageTransformer(ZoomOutPageTransformer())

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }

//    override fun onBackPressed() {
//        if (viewPager.currentItem == 0) {
//            super.onBackPressed()
//        } else {
//            viewPager.currentItem = viewPager.currentItem - 1
//        }
//    }
}
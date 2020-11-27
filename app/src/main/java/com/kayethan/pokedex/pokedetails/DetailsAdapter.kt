package com.kayethan.pokedex.pokedetails

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kayethan.pokedex.pokedata.PokeData
import com.kayethan.pokedex.pokedata.PokemonData

class DetailsAdapter(fa: FragmentActivity, val pokemonData: PokemonData) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            DescriptionFragment()
        } else {
            LocationsFragment()
        }
    }
}
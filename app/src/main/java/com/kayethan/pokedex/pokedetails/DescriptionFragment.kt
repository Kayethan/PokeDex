package com.kayethan.pokedex.pokedetails

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.kayethan.pokedex.DetailsActivity
import com.kayethan.pokedex.R
import com.kayethan.pokedex.databinding.FragmentDescriptionBinding
import com.kayethan.pokedex.pokedata.PokemonData
import com.kayethan.pokedex.pokelist.PokemonAdapter
import kotlinx.android.synthetic.main.fragment_description.*
import java.util.*

class DescriptionFragment : Fragment() {
    private lateinit var binding: FragmentDescriptionBinding

    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDescriptionBinding.bind(view)

        iconDetailIV.setImageResource(DetailsActivity.pokemonData.basicPokemonData.icon)
        detailsNameTV.text = DetailsActivity.pokemonData.basicPokemonData.name

        val type1 = DetailsActivity.pokemonData.basicPokemonData.type1

        detailsType1TV.text = type1.getTypeName(PokemonAdapter.context).toUpperCase()
        val gd1 = GradientDrawable()
        gd1.setColor(type1.getContentColor(PokemonAdapter.context))
        gd1.cornerRadius = PokemonAdapter.CORNER_RADIUS
        gd1.setStroke(PokemonAdapter.STROKE_WIDTH, type1.getBorderColor(PokemonAdapter.context))
        detailsType1TV.background = gd1

        val type2 = DetailsActivity.pokemonData.basicPokemonData.type2

        if (type2 != null) {
            detailsType2TV.isVisible = true
            detailsType2TV.text = type2.getTypeName(PokemonAdapter.context).toUpperCase(Locale.ROOT)
            val gd2 = GradientDrawable()
            gd2.setColor(type2.getContentColor(PokemonAdapter.context))
            gd2.cornerRadius = PokemonAdapter.CORNER_RADIUS
            gd2.setStroke(PokemonAdapter.STROKE_WIDTH, type2.getBorderColor(PokemonAdapter.context))
            detailsType2TV.background = gd2
        }
        else
        {
            detailsType2TV.isVisible = false
        }

        detailsHeightTV.text = getString(R.string.height_kg, DetailsActivity.pokemonData.detailsPokemonData.height)
        detailsWeightTV.text = getString(R.string.weight_m, DetailsActivity.pokemonData.detailsPokemonData.weight)

        detailsPokeTypeTV.text = getString(DetailsActivity.pokemonData.detailsPokemonData.pokemonType)
        detailsLevelingRateTV.text = DetailsActivity.pokemonData.detailsPokemonData.levelingRate.getString(PokemonAdapter.context)

        detailsDescTV.text = getString(DetailsActivity.pokemonData.detailsPokemonData.descriptionText)
    }
}
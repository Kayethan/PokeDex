package com.kayethan.pokedex.pokedetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kayethan.pokedex.DetailsActivity
import com.kayethan.pokedex.R
import com.kayethan.pokedex.databinding.FragmentLocationsBinding
import com.kayethan.pokedex.pokedata.GameLocation
import kotlinx.android.synthetic.main.fragment_locations.*

class LocationsFragment : Fragment() {
    private lateinit var binding: FragmentLocationsBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLocationsBinding.bind(view)

        viewManager = LinearLayoutManager(context)
        LocationsAdapter.context = requireContext()

        val locations = DetailsActivity.pokemonData.gameLocations
        viewAdapter = LocationsAdapter(locations)

        recyclerView = locationsRV.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        recyclerView.addItemDecoration(
                LocationDivider(requireContext())
        )
    }
}
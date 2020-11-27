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

    class LocationsAdapter(private val locations: List<GameLocation>) : RecyclerView.Adapter<LocationsAdapter.LocationViewHolder>() {
        companion object {
            lateinit var context: Context
        }

        inner class LocationViewHolder(locationView: View) : RecyclerView.ViewHolder(locationView) {
            val locationNameTextView: TextView = locationView.findViewById(R.id.locationNameTV)
            val locationLvlTextView: TextView = locationView.findViewById(R.id.locationRangeTV)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
            val entryView = LayoutInflater.from(parent.context).inflate(R.layout.game_location_line, parent, false)
            return LocationViewHolder(entryView)
        }

        override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
            val location = locations[position]
            holder.locationNameTextView.text = location.route.getString(context)
            holder.locationLvlTextView.text = context.getString(R.string.location_lvl_range, location.levelRange.first, location.levelRange.last)
        }

        override fun getItemCount(): Int {
            return locations.size
        }
    }
}
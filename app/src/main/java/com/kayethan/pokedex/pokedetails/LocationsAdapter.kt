package com.kayethan.pokedex.pokedetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kayethan.pokedex.R
import com.kayethan.pokedex.pokedata.GameLocation

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
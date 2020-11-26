package com.kayethan.pokedex.pokelist

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.kayethan.pokedex.R
import kotlinx.android.synthetic.main.pokemon_entry.view.*

class PokemonAdapter(var entriesDataset: ArrayList<PokemonEntry>, private val listener: OnItemClickListener) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    companion object {
        lateinit var context: Context
        const val CORNER_RADIUS: Float = 8.0f
        const val STROKE_WIDTH: Int = 4
    }

    interface ClickListener {
        fun onItemClick(position: Int, view: View)
    }

    inner class PokemonViewHolder(entryView: View) : RecyclerView.ViewHolder(entryView), View.OnClickListener {
        val nameTextView: TextView = entryView.findViewById(R.id.nameTV)
        val iconImageView: ImageView = entryView.findViewById(R.id.iconIV)
        val favoriteImageButton: ImageButton = entryView.findViewById(R.id.favoriteBT)
        val type1TextView: TextView = entryView.findViewById(R.id.type1TV)
        val type2TextView: TextView = entryView.findViewById(R.id.type2TV)
        val numberTextView: TextView = entryView.findViewById(R.id.numberTV)

        lateinit var pokemonEntry: PokemonEntry

        init {
            itemView.setOnClickListener(this)
            entryView.favoriteBT.setOnClickListener {
                onFavoriteClick(this.itemView)
            }
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(adapterPosition, pokemonEntry)
            }
        }

        private fun onFavoriteClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onFavoriteClick(adapterPosition, pokemonEntry)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val entryView = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_entry, parent, false)
        return PokemonViewHolder(entryView)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val entry: PokemonEntry = entriesDataset[position]
        holder.pokemonEntry = entry

        if (entry.favorite) {
            holder.favoriteImageButton.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_checked))
        } else {
            holder.favoriteImageButton.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_unchecked))
        }

        holder.nameTextView.text = entry.pokemonName
        holder.iconImageView.setImageResource(entry.icon)

        holder.type1TextView.text = entry.type1.getTypeName(context).toUpperCase()
        val gd1 = GradientDrawable()
        gd1.setColor(entry.type1.getContentColor(context))
        gd1.cornerRadius = CORNER_RADIUS
        gd1.setStroke(STROKE_WIDTH, entry.type1.getBorderColor(context))
        holder.type1TextView.background = gd1

        if (entry.type2 != null) {
            holder.type2TextView.isVisible = true
            holder.type2TextView.text = entry.type2!!.getTypeName(context).toUpperCase()
            val gd2 = GradientDrawable()
            gd2.setColor(entry.type2!!.getContentColor(context))
            gd2.cornerRadius = CORNER_RADIUS
            gd2.setStroke(STROKE_WIDTH, entry.type2!!.getBorderColor(context))
            holder.type2TextView.background = gd2
        }
        else
        {
            holder.type2TextView.isVisible = false
        }

        holder.numberTextView.text = "#" + entry.pokemonNumber.toString().padStart(3, '0')
    }

    override fun getItemCount(): Int {
        return entriesDataset.size
    }

    fun removeAt(position: Int) {
        entriesDataset.removeAt(position)
        notifyItemRemoved(position)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, pokemonEntry: PokemonEntry)
        fun onFavoriteClick(position: Int, pokemonEntry: PokemonEntry)
    }
}
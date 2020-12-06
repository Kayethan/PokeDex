package com.kayethan.pokedex.pokedata

import android.content.Context
import com.kayethan.pokedex.R

enum class LevelingRate {
    MediumSlow {
        override fun getString(context: Context): String { return context.getString(R.string.medium_slow) }
    },
    MediumFast {
        override fun getString(context: Context): String { return context.getString(R.string.medium_fast) }
    };

    abstract fun getString(context: Context): String
}
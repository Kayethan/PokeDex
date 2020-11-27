package com.kayethan.pokedex.pokedata

import android.content.Context
import com.kayethan.pokedex.R

enum class Route {
    ProfessorOak {
        override fun getString(context: Context): String { return context.getString(R.string.professorOak) }
    },
    Route001 {
        override fun getString(context: Context): String { return context.getString(R.string.route001) }
    };

    abstract fun getString(context: Context): String
}
package com.kayethan.pokedex.pokedata

import android.content.Context
import com.kayethan.pokedex.R

enum class Route {
    ProfessorOak {
        override fun getString(context: Context): String { return context.getString(R.string.professor_oak) }
    },
    Evolution {
        override fun getString(context: Context): String { return context.getString(R.string.evolution) }
    },
    ViridianForest {
        override fun getString(context: Context): String { return context.getString(R.string.viridian_forest) }
    },
    PatternBush {
        override fun getString(context: Context): String { return context.getString(R.string.pattern_bush) }
    },
    BondBridge {
        override fun getString(context: Context): String { return context.getString(R.string.bond_bridge) }
    },
    BerryForest {
        override fun getString(context: Context): String { return context.getString(R.string.berry_forest) }
    },
    FiveIsleMeadow {
        override fun getString(context: Context): String { return context.getString(R.string.five_isle_meadow) }
    },
    Route001 {
        override fun getString(context: Context): String { return context.getString(R.string.route001) }
    },
    Route002 {
        override fun getString(context: Context): String { return context.getString(R.string.route002) }
    },
    Route003 {
        override fun getString(context: Context): String { return context.getString(R.string.route003) }
    },
    Route004 {
        override fun getString(context: Context): String { return context.getString(R.string.route004) }
    },
    Route005 {
        override fun getString(context: Context): String { return context.getString(R.string.route005) }
    },
    Route006 {
        override fun getString(context: Context): String { return context.getString(R.string.route006) }
    },
    Route007 {
        override fun getString(context: Context): String { return context.getString(R.string.route007) }
    },
    Route008 {
        override fun getString(context: Context): String { return context.getString(R.string.route008) }
    },
    Route009 {
        override fun getString(context: Context): String { return context.getString(R.string.route009) }
    },
    Route010 {
        override fun getString(context: Context): String { return context.getString(R.string.route010) }
    },
    Route011 {
        override fun getString(context: Context): String { return context.getString(R.string.route011) }
    },
    Route012 {
        override fun getString(context: Context): String { return context.getString(R.string.route012) }
    },
    Route013 {
        override fun getString(context: Context): String { return context.getString(R.string.route013) }
    },
    Route014 {
        override fun getString(context: Context): String { return context.getString(R.string.route014) }
    },
    Route015 {
        override fun getString(context: Context): String { return context.getString(R.string.route015) }
    },
    Route016 {
        override fun getString(context: Context): String { return context.getString(R.string.route016) }
    },
    Route017 {
        override fun getString(context: Context): String { return context.getString(R.string.route017) }
    },
    Route018 {
        override fun getString(context: Context): String { return context.getString(R.string.route018) }
    },
    Route019 {
        override fun getString(context: Context): String { return context.getString(R.string.route019) }
    },
    Route020 {
        override fun getString(context: Context): String { return context.getString(R.string.route020) }
    },
    Route021 {
        override fun getString(context: Context): String { return context.getString(R.string.route021) }
    },
    Route022 {
        override fun getString(context: Context): String { return context.getString(R.string.route022) }
    },
    Route023 {
        override fun getString(context: Context): String { return context.getString(R.string.route023) }
    },
    Route024 {
        override fun getString(context: Context): String { return context.getString(R.string.route024) }
    },
    Route025 {
        override fun getString(context: Context): String { return context.getString(R.string.route025) }
    };

    abstract fun getString(context: Context): String
}
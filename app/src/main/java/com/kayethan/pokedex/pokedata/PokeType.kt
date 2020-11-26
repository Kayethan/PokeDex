package com.kayethan.pokedex.pokedata

import android.content.Context
import androidx.core.content.ContextCompat.getColor
import com.kayethan.pokedex.R

enum class PokeType {
    None {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_normal_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_normal_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_none) }
    },
    Normal {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_normal_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_normal_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_normal) }
    },
    Fire {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_fire_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_fire_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_fire) }
    },
    Fighting {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_fighting_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_fighting_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_fighting) }
    },
    Water {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_water_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_water_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_water) }
    },
    Flying {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_flying_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_flying_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_flying) }
    },
    Grass {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_grass_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_grass_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_grass) }
    },
    Poison {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_poison_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_poison_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_poison) }
    },
    Electric {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_electric_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_electric_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_electric) }
    },
    Ground {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_ground_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_ground_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_ground) }
    },
    Psychic {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_psychic_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_psychic_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_psychic) }
    },
    Rock {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_rock_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_rock_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_rock) }
    },
    Ice {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_ice_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_ice_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_ice) }
    },
    Bug {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_bug_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_bug_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_bug) }
    },
    Dragon {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_dragon_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_dragon_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_dragon) }
    },
    Ghost {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_ghost_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_ghost_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_ghost) }
    },
    Dark {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_dark_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_dark_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_dark) }
    },
    Steel {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_steel_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_steel_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_steel) }
    },
    Fairy {
        override fun getContentColor(context: Context): Int { return getColor(context, R.color.type_fairy_content) }
        override fun getBorderColor(context: Context): Int { return getColor(context, R.color.type_fairy_border) }
        override fun getTypeName(context: Context): String { return context.getString(R.string.type_fairy) }
    };

    abstract fun getContentColor(context: Context): Int
    abstract fun getBorderColor(context: Context): Int
    abstract fun getTypeName(context: Context): String
}
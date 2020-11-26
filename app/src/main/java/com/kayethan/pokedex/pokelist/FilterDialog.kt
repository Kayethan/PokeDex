package com.kayethan.pokedex.pokelist

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import com.kayethan.pokedex.R
import com.kayethan.pokedex.pokedata.PokeType
import kotlinx.android.synthetic.main.filter_dialog.view.*

class FilterDialog : AppCompatDialogFragment() {

    private lateinit var listener: FilterDialogListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // return super.onCreateDialog(savedInstanceState)
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)

        val inflater: LayoutInflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.filter_dialog, null)

        setupTypes(view)
        builder.setView(view)
            .setTitle(view.context.getString(R.string.filter_title))
            .setNegativeButton(view.context.getString(R.string.filter_cancel), object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
            .setNeutralButton(view.context.getString(R.string.filter_reset), object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    listener.filterType(PokeType.None)
                }
            })

        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as FilterDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement FilterDialogListener")
        }
    }

    interface FilterDialogListener {
        fun filterType(pokeType: PokeType)
    }

    private fun setupTypes(view: View) {
        setupType(view.normalTV, PokeType.Normal)
        setupType(view.fireTV, PokeType.Fire)
        setupType(view.fightingTV, PokeType.Fighting)
        setupType(view.waterTV, PokeType.Water)
        setupType(view.flyingTV, PokeType.Flying)
        setupType(view.grassTV, PokeType.Grass)
        setupType(view.poisonTV, PokeType.Poison)
        setupType(view.electricTV, PokeType.Electric)
        setupType(view.groundTV, PokeType.Ground)
        setupType(view.psychicTV, PokeType.Psychic)
        setupType(view.rockTV, PokeType.Rock)
        setupType(view.iceTV, PokeType.Ice)
        setupType(view.bugTV, PokeType.Bug)
        setupType(view.dragonTV, PokeType.Dragon)
        setupType(view.ghostTV, PokeType.Ghost)
        setupType(view.darkTV, PokeType.Dark)
        setupType(view.steelTV, PokeType.Steel)
        setupType(view.fairyTV, PokeType.Fairy)
    }

    private fun setupType(textView: TextView, pokeType: PokeType) {
        val gd = GradientDrawable()
        gd.setColor(pokeType.getContentColor(PokemonAdapter.context))
        gd.cornerRadius = PokemonAdapter.CORNER_RADIUS
        gd.setStroke(PokemonAdapter.STROKE_WIDTH, pokeType.getBorderColor(PokemonAdapter.context))
        textView.background = gd

        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                listener.filterType(pokeType)
                dismiss()
            }
        })
    }
}
package com.kayethan.pokedex

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kayethan.pokedex.databinding.ActivityMainBinding
import com.kayethan.pokedex.pokedata.PokeType
import com.kayethan.pokedex.pokedata.PokemonDatabase
import com.kayethan.pokedex.pokelist.FilterDialog
import com.kayethan.pokedex.pokelist.PokemonAdapter
import com.kayethan.pokedex.pokelist.PokemonEntry
import com.kayethan.pokedex.pokelist.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PokemonAdapter.OnItemClickListener, FilterDialog.FilterDialogListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var menu: Menu

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PokemonAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var deletedNumbers: ArrayList<Int> = ArrayList<Int>()
    private var favoriteNumbers: ArrayList<Int> = ArrayList<Int>()

    private var showOnlyFavorites: Boolean = false
    private var showOnlyType: PokeType = PokeType.None

    companion object {
        const val SHARED_PREFFERENCES = "POKE_DEX"
        const val FAVORITE_NUMBERS_KEY = "FAVORITE_NUMBERS_KEY"
        const val DELETED_NUMBERS_KEY = "DELETED_NUMBERS_KEY"
        const val SHOW_ONLY_FAVORITES_KEY = "SHOW_ONLY_FAVORITES_KEY"
        const val SHOW_ONLY_TYPE_KEY = "SHOW_ONLY_TYPE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFavorites()

        viewManager = LinearLayoutManager(this)
        val entries = ArrayList<PokemonEntry>()

        for (pokemon in PokemonDatabase.getPokemonList()) {
            val pokemonEntry = pokemon.toPokemonEntry()
            pokemonEntry.favorite = favoriteNumbers.contains(pokemonEntry.pokemonNumber)
            entries.add(pokemonEntry)
        }

        PokemonAdapter.context = this@MainActivity
        viewAdapter = PokemonAdapter(entries, this@MainActivity)

        val swipeHandler = object : SwipeToDeleteCallback(this@MainActivity) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = recyclerView.adapter as PokemonAdapter
                TODO("TEST")
                // val viewHolder: PokemonAdapter.PokemonViewHolder = viewHolder as PokemonAdapter.PokemonViewHolder
                deletedNumbers.add(adapter.entriesDataset[viewHolder.adapterPosition].pokemonNumber)
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)

        recyclerView = pokemonRV.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.i("test", "onSaveInstanceState")

        outState.putIntegerArrayList(DELETED_NUMBERS_KEY, deletedNumbers)
        outState.putBoolean(SHOW_ONLY_FAVORITES_KEY, showOnlyFavorites)
        outState.putSerializable(SHOW_ONLY_TYPE_KEY, showOnlyType)

        saveFavorites()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.i("test", "onRestoreInstanceState")

        deletedNumbers = savedInstanceState.getIntegerArrayList(DELETED_NUMBERS_KEY) as ArrayList<Int>
        showOnlyFavorites = savedInstanceState.getBoolean(SHOW_ONLY_FAVORITES_KEY)
        showOnlyType = savedInstanceState.getSerializable(SHOW_ONLY_TYPE_KEY) as PokeType

        loadFavorites()

        filterEntriesList(showOnlyFavorites, showOnlyType)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu != null)
            this.menu = menu
        menuInflater.inflate(R.menu.app_menu, menu)

        if (showOnlyFavorites)
        {
            val item = this.menu.findItem(R.id.action_favorites)
            item.isChecked = true
            item.setIcon(R.drawable.ic_favorite_checked)
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorites -> {
                item.isChecked = !item.isChecked

                if (item.isChecked) {
                    item.setIcon(R.drawable.ic_favorite_checked)
                    showOnlyFavorites()
                } else {
                    item.setIcon(R.drawable.ic_favorite_unchecked)
                    showOnlyFavorites = false
                    showOnlyType(showOnlyType)
                }
            }
            R.id.action_filter_types -> {
                openFilterDialog()
            }
            R.id.action_reset_list -> {
                deletedNumbers = ArrayList<Int>()
                filterEntriesList(showOnlyFavorites, showOnlyType)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(position: Int, pokemonEntry: PokemonEntry) {
        Log.i("test", "Item clicked: $position, name: ${pokemonEntry.pokemonName}")
    }

    override fun onFavoriteClick(position: Int, pokemonEntry: PokemonEntry) {
        Log.i("test", "Favorite clicked: $position, name: ${pokemonEntry.pokemonNumber}")

        if (favoriteNumbers.contains(pokemonEntry.pokemonNumber)) {
            favoriteNumbers.remove(pokemonEntry.pokemonNumber)
            pokemonEntry.favorite = false
        } else {
            favoriteNumbers.add(pokemonEntry.pokemonNumber)
            pokemonEntry.favorite = true
        }

        pokemonRV.adapter?.notifyItemChanged(position)
    }

    private fun showOnlyFavorites() {
        showOnlyFavorites = true
        filterEntriesList(true, showOnlyType)
    }

    private fun showOnlyType(pokeType: PokeType) {
        showOnlyType = pokeType
        filterEntriesList(showOnlyFavorites, pokeType)
    }

    private fun showAll() {
        showOnlyType = PokeType.None
        showOnlyFavorites = false
        filterEntriesList(showOnlyFavorites, showOnlyType)
    }

    private fun saveFavorites() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFFERENCES, 0)
        sharedPreferences.edit().apply {
            var saveString = ""
            for (i in 0 until favoriteNumbers.size) {
                saveString += favoriteNumbers[i].toString()
                if (i != favoriteNumbers.size - 1)
                    saveString += "|"
            }
            putString(FAVORITE_NUMBERS_KEY, saveString)

            apply()
        }
    }

    private fun loadFavorites() {
        favoriteNumbers = ArrayList<Int>()
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFFERENCES, 0)
        // var stringList = sharedPreferences.getString(FAVORITE_NUMBERS_KEY, "")!!.split("|")
        val string_serial = sharedPreferences.getString(FAVORITE_NUMBERS_KEY, "")

        if (string_serial != "") {
            for (number in string_serial!!.split("|")) {
                favoriteNumbers.add(number.toInt())
            }
        }
    }

    private fun filterEntriesList(showOnlyFavorites: Boolean, showOnlyType: PokeType) {
        val entries = ArrayList<PokemonEntry>()
        for (pokemon in PokemonDatabase.getPokemonList()) {
            val pokemonEntry = pokemon.toPokemonEntry()
            if (pokemonEntry.pokemonNumber in favoriteNumbers) {
                pokemonEntry.favorite = true
            }

            if (
                (pokemonEntry.pokemonNumber !in deletedNumbers)
                && (!showOnlyFavorites || pokemonEntry.favorite)
                && (showOnlyType == PokeType.None || pokemonEntry.type1 == showOnlyType || pokemonEntry.type2 == showOnlyType)
            ) {
                entries.add(pokemonEntry)
            }
        }

        (pokemonRV.adapter as PokemonAdapter).entriesDataset = entries
        pokemonRV.adapter?.notifyDataSetChanged()
    }

    private fun openFilterDialog() {
        val filterDialog = FilterDialog()
        filterDialog.show(supportFragmentManager, "filter_dialog")
    }

    override fun filterType(pokeType: PokeType) {
        Log.i("FILTER_TYPE", "${pokeType.getTypeName(this@MainActivity)}")
        showOnlyType(pokeType)
    }
}
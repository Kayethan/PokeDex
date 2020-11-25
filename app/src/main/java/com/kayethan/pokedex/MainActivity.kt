package com.kayethan.pokedex

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
import com.kayethan.pokedex.pokedata.PokemonDatabase
import com.kayethan.pokedex.pokelist.PokemonAdapter
import com.kayethan.pokedex.pokelist.PokemonEntry
import com.kayethan.pokedex.pokelist.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PokemonAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var menu: Menu

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PokemonAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var deletedIdx: ArrayList<Int> = ArrayList<Int>()
    private var favoriteNumbers: ArrayList<Int> = ArrayList<Int>()

    companion object {
        const val LIST_KEY = "LIST_STATE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
        val entries = ArrayList<PokemonEntry>()

        for (pokemon in PokemonDatabase.getPokemonList()) {
            entries.add(pokemon.toPokemonEntry())
        }

        PokemonAdapter.context = this@MainActivity
        viewAdapter = PokemonAdapter(entries, this@MainActivity)

        val swipeHandler = object : SwipeToDeleteCallback(this@MainActivity) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = recyclerView.adapter as PokemonAdapter
                deletedIdx.add(viewHolder.adapterPosition)
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

        outState.putIntegerArrayList(LIST_KEY, deletedIdx)
        for (idx in deletedIdx) {
            Log.i("test", "Deleted: $idx")
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.i("test", "onRestoreInstanceState")

        deletedIdx = savedInstanceState.getIntegerArrayList(LIST_KEY) as ArrayList<Int>
    }

    override fun onResume() {
        super.onResume()

        for (idx in deletedIdx) {
            viewAdapter.removeAt(idx)
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu != null)
            this.menu = menu
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorites -> {
                item.isChecked = !item.isChecked

                if (item.isChecked) {
                    item.setIcon(R.drawable.ic_favorite_checked)
                } else {
                    item.setIcon(R.drawable.ic_favorite_unchecked)
                }
            }
            R.id.action_filter_types -> {

            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(position: Int, pokemonEntry: PokemonEntry) {
        Log.i("test", "Item clicked: $position, name: ${pokemonEntry.pokemonName}")
    }

    override fun onFavoriteClick(position: Int, pokemonEntry: PokemonEntry) {
        Log.i("test", "Favorite clicked: $position, name: ${pokemonEntry.pokemonNumber}")
    }
}
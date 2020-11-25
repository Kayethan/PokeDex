package com.kayethan.pokedex

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var menu: Menu

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var mBundleRecyclerViewState: Bundle? = null

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
        viewAdapter = PokemonAdapter(entries)

        val swipeHandler = object : SwipeToDeleteCallback(this@MainActivity) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = recyclerView.adapter as PokemonAdapter
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
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.i("test", "onRestoreInstanceState")
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
}
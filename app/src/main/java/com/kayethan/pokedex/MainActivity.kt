package com.kayethan.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.kayethan.pokedex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.i("test", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.i("test", "onRestoreInstanceState")
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

                if (item.isChecked)
                {
                    item.setIcon(R.drawable.ic_favorite_checked)
                }
                else
                {
                    item.setIcon(R.drawable.ic_favorite_unchecked)
                }
            }
            R.id.action_filter_types -> {

            }
        }

        return super.onOptionsItemSelected(item)
    }
}
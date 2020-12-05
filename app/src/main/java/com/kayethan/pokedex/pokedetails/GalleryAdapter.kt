package com.kayethan.pokedex.pokedetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kayethan.pokedex.R

class GalleryAdapter(private val photos: List<Int>) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {
    companion object {
        lateinit var context: Context
    }

    inner class GalleryViewHolder(photoView: View) : RecyclerView.ViewHolder(photoView) {
        val galleryIV: ImageView = photoView.findViewById(R.id.galleryIV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val photoView = LayoutInflater.from(parent.context).inflate(R.layout.photo_entry, parent, false)
        return GalleryViewHolder(photoView)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.galleryIV.setImageResource(photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}
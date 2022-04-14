package com.app.tmdbclient.presentation.artist

import androidx.recyclerview.widget.RecyclerView
import com.app.tmdbclient.data.model.artist.Artist
import com.app.tmdbclient.databinding.ListItemBinding

class ArtistAdapter {
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(artist : Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.
    }
}
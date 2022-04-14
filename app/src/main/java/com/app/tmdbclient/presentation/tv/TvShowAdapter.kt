package com.app.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.tmdbclient.R
import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.model.tvshow.TvShow
import com.app.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvShowAdapter() : RecyclerView.Adapter<MyViewHolderTvShow>() {

    private val tvList = ArrayList<TvShow>()

    fun setList(tvShow : List<TvShow>){
        tvList.clear()
        tvList.addAll(tvShow)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderTvShow {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolderTvShow(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolderTvShow, position: Int) {
        holder.bind(tvList[position])
    }

    override fun getItemCount(): Int {
        return tvList.size
    }
}

class MyViewHolderTvShow(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){


    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}
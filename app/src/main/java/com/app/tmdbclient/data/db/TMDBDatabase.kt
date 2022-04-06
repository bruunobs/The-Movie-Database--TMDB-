package com.app.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.tmdbclient.data.model.artist.Artist
import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){

    abstract fun movieDao(): MovieDAO
    abstract fun artistDao() : ArtistDAO
    abstract fun tvShowDao() : TvShowDAO

}
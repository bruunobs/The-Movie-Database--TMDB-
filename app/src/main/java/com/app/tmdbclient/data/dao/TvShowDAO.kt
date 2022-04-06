package com.app.tmdbclient.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.tmdbclient.data.model.tvshow.TvShow

@Dao
interface TvShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvshow : List<TvShow>)

    @Query(value = "DELETE FROM popular_tvshows")
    suspend fun deleteAllTvShows(tvshow: List<TvShow>)

    @Query(value = "SELECT * FROM popular_tvshows")
    suspend fun getTvShows(tvshow: List<TvShow>)
}
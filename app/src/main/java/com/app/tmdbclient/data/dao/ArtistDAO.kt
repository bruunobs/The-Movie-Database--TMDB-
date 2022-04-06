package com.app.tmdbclient.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists : List<Artist>)

    @Query(value = "DELETE FROM popular_artists")
    suspend fun deleteAllArtists(artists: List<Artist>)

    @Query(value = "SELECT * FROM popular_artists")
    suspend fun getArtists(artists: List<Artist>)

}

package com.app.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.tmdbclient.data.model.movie.Movie


@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query(value = "DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query(value = "SELECT * FROM popular_movies")
    suspend fun getMovies() : List<Movie>
}
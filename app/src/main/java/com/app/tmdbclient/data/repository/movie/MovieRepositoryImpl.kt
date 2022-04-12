package com.app.tmdbclient.data.repository.movie

import android.util.Log
import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.app.tmdbclient.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesFromCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if(body!=null){
                movieList = body.movies
            }
        }catch (exception : Exception){
            Log.i("Tag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        }catch (exception : Exception){
            Log.i("Tag", exception.message.toString())
        }
        if (movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDatasource.getMoviesFromCache()
        }catch (exception : Exception){
            Log.i("Tag", exception.message.toString())
        }
        if (movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDatasource.saveMoviesFromCache(movieList)
        }
        return movieList
    }

}


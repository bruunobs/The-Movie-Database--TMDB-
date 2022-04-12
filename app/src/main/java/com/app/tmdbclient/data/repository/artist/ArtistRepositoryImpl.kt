package com.app.tmdbclient.data.repository.artist

import android.util.Log
import com.app.tmdbclient.data.model.artist.Artist
import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.app.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.app.tmdbclient.data.repository.artist.datasource.ArtistsRemoteDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.app.tmdbclient.domain.repository.ArtistRepository
import com.app.tmdbclient.domain.repository.MovieRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistsRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistsFromCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI() : List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        }catch (exception : Exception){
            Log.i("Tag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB() : List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDatasource.getArtistsFromDB()
        }catch (exception : Exception){
            Log.i("Tag", exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache() : List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistsFromCache()
        }catch (exception : Exception){
            Log.i("Tag", exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDatasource.saveArtistsFromCache(artistList)
        }
        return artistList
    }

}

package com.app.tmdbclient.data.repository.tvshow

import android.util.Log
import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.model.tvshow.TvShow
import com.app.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.app.tmdbclient.domain.repository.MovieRepository
import com.app.tmdbclient.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTvShowsFromCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI() : List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if(body!=null){
                tvShowList = body.tvShows
            }
        }catch (exception : Exception){
            Log.i("Tag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB() : List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDatasource.getTvShowsFromDB()
        }catch (exception : Exception){
            Log.i("Tag", exception.message.toString())
        }
        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache() : List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDatasource.getTvShowsFromCache()
        }catch (exception : Exception){
            Log.i("Tag", exception.message.toString())
        }
        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowsFromCache(tvShowList)
        }
        return tvShowList
    }

}


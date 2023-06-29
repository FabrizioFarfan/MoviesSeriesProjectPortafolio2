package com.example.moviesseriesproject.data.repository.movie

import android.util.Log
import com.example.moviesseriesproject.data.model.movie.Movie
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieCacheDataSource
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieLocalDataSource
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.moviesseriesproject.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {

        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newMoviesList = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMoviesList)
        movieCacheDataSource.saveMoviesToCache(newMoviesList)

        return newMoviesList
    }

    suspend fun getMoviesFromApi():List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) movieList = body.movies
        }catch (e: Exception){
            Log.i("My Tag",e.message.toString())
        }


        return movieList
    }

    suspend fun getMoviesFromDatabase():List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (e: Exception){
            Log.i("My Tag",e.message.toString())
        }

        if (movieList.isNotEmpty()) return movieList
            else{
                movieList = getMoviesFromApi()
                movieLocalDataSource.saveMoviesToDB(movieList)
            }

        return movieList
    }


    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e: Exception){
            Log.i("My Tag",e.message.toString())
        }

        if (movieList.isNotEmpty()) return movieList
        else{
            movieList = getMoviesFromDatabase()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}
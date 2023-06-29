package com.example.moviesseriesproject.data.repository.movie.datasourceimpl

import com.example.moviesseriesproject.data.db.MovieDao
import com.example.moviesseriesproject.data.model.movie.Movie
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(IO).launch{
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch{
            movieDao.deleteAllMovies()
        }
    }
}
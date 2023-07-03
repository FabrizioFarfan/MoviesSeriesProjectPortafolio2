package com.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviesseriesproject.data.db.MovieDao
import com.example.moviesseriesproject.data.db.MoviesSeriesDatabase
import com.example.moviesseriesproject.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: MoviesSeriesDatabase

    @Before
    fun setUp(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MoviesSeriesDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun saveAndGetMovieTest() = runBlocking {
        val movies = listOf(
            Movie(1,"overview1","posterPath1","releaseDate1","title1"),
            Movie(2,"overview2","posterPath2","releaseDate2","title2"),
            Movie(3,"overview3","posterPath3","releaseDate3","title3"),
        )
        dao.saveMovies(movies)

        val allMovies = dao.getMovies()

        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMovieTest()= runBlocking {
        val movies = listOf(
            Movie(1,"overview1","posterPath1","releaseDate1","title1"),
            Movie(2,"overview2","posterPath2","releaseDate2","title2"),
            Movie(3,"overview3","posterPath3","releaseDate3","title3"),
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()
        val moviesResult = dao.getMovies()
        Truth.assertThat(moviesResult).isEmpty()
    }
}
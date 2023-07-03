package com.example.moviesseriesproject.ui.viewmodel.movie

import  androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviesseriesproject.data.model.movie.Movie
import com.example.moviesseriesproject.data.repository.movie.FakeMovieRepositoryImpl
import com.example.moviesseriesproject.domain.usecase.GetMoviesUseCase
import com.example.moviesseriesproject.domain.usecase.UpdateMoviesUseCase
import com.example.moviesseriesproject.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepositoryImpl = FakeMovieRepositoryImpl()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepositoryImpl)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepositoryImpl)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1,"overview1","posterPath1","date1","title1"))
        movies.add(Movie(2,"overview2","posterPath2","date2","title2"))
        movies.add(Movie(3,"overview3","posterPath3","date3","title3"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnUpdatedList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(4,"overview4","posterPath4","date4","title4"))
        movies.add(Movie(5,"overview5","posterPath5","date5","title5"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }


}
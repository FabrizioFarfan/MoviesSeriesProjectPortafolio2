package com.example.moviesseriesproject.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesseriesproject.databinding.ActivityMainBinding
import com.example.moviesseriesproject.ui.view.artist.ArtistActivity
import com.example.moviesseriesproject.ui.view.movie.MovieActivity
import com.example.moviesseriesproject.ui.view.tvshow.TvShowActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.movieButton.setOnClickListener {
            val intentMovie = Intent(this,MovieActivity::class.java)
            startActivity(intentMovie)
        }

        binding.tvShowButton.setOnClickListener {
            val intentTvShow = Intent(this, TvShowActivity::class.java)
            startActivity(intentTvShow)
        }

        binding.artistButton.setOnClickListener {
            val intentArtist = Intent(this, ArtistActivity::class.java)
            startActivity(intentArtist)
        }
    }

}
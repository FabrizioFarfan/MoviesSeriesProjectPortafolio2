package com.example.moviesseriesproject.ui.view.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesseriesproject.data.model.movie.Movie
import com.example.moviesseriesproject.databinding.ListItemBinding

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val listMovie = ArrayList<Movie>()
    fun setList(movies: List<Movie>){
        listMovie.clear()
        listMovie.addAll(movies)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size


    inner class MovieViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.titleTV.text = movie.title
            binding.descriptionTV.text = movie.overview
            val posterURL = "https://image.tmdb.org/t/p/w500/"+movie.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }


}


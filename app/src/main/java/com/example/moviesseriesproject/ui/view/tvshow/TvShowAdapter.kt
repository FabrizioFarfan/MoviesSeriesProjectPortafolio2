package com.example.moviesseriesproject.ui.view.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesseriesproject.data.model.tvshow.TvShow
import com.example.moviesseriesproject.databinding.ListItemBinding


class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var tvShowsList = ArrayList<TvShow>()

    fun setList(tvShows : List<TvShow>){
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return TvShowViewHolder(binding)
    }


    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowsList[position])
    }

    override fun getItemCount(): Int = tvShowsList.size



inner class TvShowViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow){
        binding.titleTV.text = tvShow.name
        binding.descriptionTV.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500/"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }

}



}
package com.example.moviesseriesproject.ui.view.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesseriesproject.data.model.artist.Artist
import com.example.moviesseriesproject.databinding.ListItemBinding



class ArtistAdapter: RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    var artistsList = ArrayList<Artist>()

    fun setList(artists: List<Artist>){
        artistsList.clear()
        artistsList.addAll(artists)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArtistViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistsList[position])
    }

    override fun getItemCount(): Int = artistsList.size


inner class ArtistViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(artist: Artist){
        binding.titleTV.text = artist.name
        binding.descriptionTV.text = artist.popularity.toString()
        val posterURL = "https://image.tmdb.org/t/p/w500/"+artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }


}
}
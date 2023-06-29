package com.example.moviesseriesproject.ui.view.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesseriesproject.R
import com.example.moviesseriesproject.databinding.ActivityArtistBinding
import com.example.moviesseriesproject.ui.di.Injector
import com.example.moviesseriesproject.ui.viewmodel.artist.ArtistViewModel
import com.example.moviesseriesproject.ui.viewmodel.artist.ArtistViewModelFactory
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    private lateinit var adapter: ArtistAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createArtistSubComponent()
            .inject(this)
        artistViewModel = ViewModelProvider(this, factory)
            .get(ArtistViewModel::class.java)
        innitRecyclerView()
    }


    private fun innitRecyclerView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE

        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this){
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
            }
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update ->{
                Toast.makeText(applicationContext,"Artists update",Toast.LENGTH_LONG).show()
                updateArtists()

                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE

        val responseUpdate = artistViewModel.updateArtists()
        responseUpdate.observe(this){
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
            }

        }

    }


}
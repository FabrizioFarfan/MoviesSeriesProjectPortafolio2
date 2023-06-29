package com.example.moviesseriesproject.ui.view.tvshow

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
import com.example.moviesseriesproject.databinding.ActivityTvShowBinding
import com.example.moviesseriesproject.ui.di.Injector
import com.example.moviesseriesproject.ui.viewmodel.tvshow.TvShowViewModel
import com.example.moviesseriesproject.ui.viewmodel.tvshow.TvShowViewModelFactory
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createTvShowSubComponent()
            .inject(this)
        tvShowViewModel = ViewModelProvider(this,factory)
            .get(TvShowViewModel::class.java)
        innitRecyclerView()
    }

    private fun innitRecyclerView(){
        binding.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvshowRecyclerView.adapter = adapter
        displayPopularTvShows()
    }


    private fun displayPopularTvShows(){
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this){
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE

            }else{
                binding.tvshowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"Not data available",Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updatePopularTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updatePopularTvShows(){
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShows()
        response.observe(this){
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE
            }else{
                binding.tvshowProgressBar.visibility = View.GONE
            }
        }
    }
}
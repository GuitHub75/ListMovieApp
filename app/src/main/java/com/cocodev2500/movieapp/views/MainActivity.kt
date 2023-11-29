package com.cocodev2500.movieapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.cocodev2500.movieapp.R
import com.cocodev2500.movieapp.databinding.ActivityMainBinding
import com.cocodev2500.movieapp.viewmodels.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MovieViewModel
    private lateinit var Mivieadapter : AddapterMovie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        setuRecicleView()

        viewModel.movieList.observe(this) {
            Mivieadapter.listMovie = it
            Mivieadapter.notifyDataSetChanged()
        }

        binding.cvCartelera.setOnClickListener {
            viewModel.getCartelera()
            changeColorbtn("car")
        }
        binding.cvPopulares.setOnClickListener {
            viewModel.getPopular()
            changeColorbtn("pop")
        }
        viewModel.getCartelera()
    }

    private fun changeColorbtn(string: String) {
        when(string){
            "car" -> {
                binding.cvCartelera.setCardBackgroundColor(getColor(R.color.green))
                binding.cvPopulares.setCardBackgroundColor(getColor(R.color.azul))
            }
            "pop" -> {
                binding.cvCartelera.setCardBackgroundColor(getColor(R.color.azul))
                binding.cvPopulares.setCardBackgroundColor(getColor(R.color.green))
            }
        }
    }

    private fun setuRecicleView() {
        val layouManager = GridLayoutManager(this,3)
        binding.rvPeliculas.layoutManager = layouManager
        Mivieadapter = AddapterMovie(this, arrayListOf())
        binding.rvPeliculas.adapter = Mivieadapter
    }
}
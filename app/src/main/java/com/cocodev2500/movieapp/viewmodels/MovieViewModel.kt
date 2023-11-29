package com.cocodev2500.movieapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cocodev2500.movieapp.core.Constant
import com.cocodev2500.movieapp.models.MovieModel
import com.cocodev2500.movieapp.network.RetrofitCliente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel : ViewModel(){
    private var _movieList = MutableLiveData<List<MovieModel>>()
    val movieList : LiveData<List<MovieModel>> = _movieList

    fun getCartelera(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitCliente.webService.getCartelera(Constant.API_KEY)
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    _movieList.value = response.body()?.resultados?.sortedByDescending { it.votoPromedio }
                }
            }
        }
    }

    fun getPopular(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitCliente.webService.getPopular(Constant.API_KEY)
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    _movieList.value = response.body()?.resultados?.sortedByDescending { it.votoPromedio }
                }
            }
        }
    }
}
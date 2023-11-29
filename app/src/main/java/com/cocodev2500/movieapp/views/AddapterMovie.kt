package com.cocodev2500.movieapp.views

import android.content.Context
import android.transition.CircularPropagation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cocodev2500.movieapp.R
import com.cocodev2500.movieapp.core.Constant
import com.cocodev2500.movieapp.models.MovieModel

class AddapterMovie(
    val context : Context,
    var listMovie  :List<MovieModel>
):RecyclerView.Adapter<AddapterMovie.ViewHolder>() {


    class ViewHolder(view : View):RecyclerView.ViewHolder(view){
        val cvPelicula = view.findViewById<View>(R.id.cvPelicula) as CardView
        val ivPoster = view.findViewById<View>(R.id.ivPoster) as ImageView
        val pcIndicator = view.findViewById(R.id.cpiPelicula) as CircularProgressIndicator
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_pelicula,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovie[position]
        Glide
            .with(context)
            .load("${Constant.BASE_IMAGE_URL}${movie.poster}")
            .apply(RequestOptions().override(Constant.WIDTH_IMAGE, Constant.HEIGHT_IMAGE))
            .into(holder.ivPoster)

        holder.pcIndicator.maxProgress = Constant.MAX_CALIFICATION
        holder.pcIndicator.setCurrentProgress(movie.votoPromedio.toDouble())
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }


}
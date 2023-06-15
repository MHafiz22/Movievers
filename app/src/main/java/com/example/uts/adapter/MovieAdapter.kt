package com.example.uts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.R
import com.example.uts.data.MovieData

class MovieAdapter (private val context: Context, private val movie: List<MovieData>, val listener: (MovieData) -> Unit)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val movieimg = view.findViewById<ImageView>(R.id.image_movie)
        val moviename = view.findViewById<TextView>(R.id.judul_movie)
        val moviedate = view.findViewById<TextView>(R.id.tahun_movie)

        fun bindView(movie: MovieData, listener: (MovieData) -> Unit){
            movieimg.setImageResource(movie.movieimg)
            moviename.text = movie.moviename
            moviedate.text = movie.moviedate
            itemView.setOnClickListener{
                (listener(movie))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindView(movie[position], listener)
    }

    override fun getItemCount(): Int = movie.size

}
package com.example.uts

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.data.MovieData
import com.example.uts.fragment.HomeFragment

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<MovieData>(HomeFragment.INTENT_PARCELABLE)

        val movieimg = findViewById<ImageView>(R.id.movieimage)
        val moviename = findViewById<TextView>(R.id.movie_name)
        val moviedate = findViewById<TextView>(R.id.movie_date)
        val movieauthor = findViewById<TextView>(R.id.movie_author)
        val movierate = findViewById<TextView>(R.id.movie_rating)
        val movieratingbar = findViewById<RatingBar>(R.id.movieratingbar)
        val moviedesc = findViewById<TextView>(R.id.movie_description)
        val moviegenre = findViewById<TextView>(R.id.movie_kategori)

        movieimg.setImageResource(movie?.movieimg!!)
        moviename.text = movie.moviename
        moviedate.text = movie.moviedate
        movieauthor.text = movie.movieauthor
        movierate.text = movie.movierate
        movieratingbar.rating = movie.movieratingbar.toFloat()
        moviedesc.text = movie.moviedesc
        moviegenre.text = movie.moviegenre
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}
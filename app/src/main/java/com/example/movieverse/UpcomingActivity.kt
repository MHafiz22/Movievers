package com.example.movieverse

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.movieverse.data.UpcomingData
import com.example.movieverse.fragment.UpcomingFragment

class UpcomingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upcoming_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upcoming = intent.getParcelableExtra<UpcomingData>(UpcomingFragment.INTENT_PARCELABLE)

        val upcomingimg = findViewById<ImageView>(R.id.image)
        val upcomingname = findViewById<TextView>(R.id.tv_name)
        val upcomingdate = findViewById<TextView>(R.id.tv_date)
        val upcomingauthor = findViewById<TextView>(R.id.tv_author)
        val upcomingdesc = findViewById<TextView>(R.id.tv_description)
        val upcomingkategori = findViewById<TextView>(R.id.tv_kategori)

        upcomingimg.setImageResource(upcoming?.upcomingimg!!)
        upcomingname.text = upcoming.upcomingname
        upcomingdate.text = upcoming.upcomingdate
        upcomingauthor.text = upcoming.upcomingauthor
        upcomingdesc.text = upcoming.upcomingdesc
        upcomingkategori.text = upcoming.upcominggenre
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}
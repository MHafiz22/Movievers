package com.example.uts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.R
import com.example.uts.data.UpcomingData

class UpcomingAdapter (private val context: Context, private val upcoming: List<UpcomingData>, val listener: (UpcomingData) -> Unit)
    : RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>(){
    class UpcomingViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val upcomingimg = view.findViewById<ImageView>(R.id.image)
        val upcomingname = view.findViewById<TextView>(R.id.tv_name)
        val upcomingdate = view.findViewById<TextView>(R.id.tv_date)
        val upcominggenre = view. findViewById<TextView>(R.id.tv_genre)

        fun bindView(upcoming: UpcomingData, listener: (UpcomingData) -> Unit){
            upcomingimg.setImageResource(upcoming.upcomingimg)
            upcomingname.text = upcoming.upcomingname
            upcomingdate.text = upcoming.upcomingdate
            upcominggenre.text = upcoming.upcominggenre
            itemView.setOnClickListener{
                (listener(upcoming))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        return UpcomingViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_upcoming, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        holder.bindView(upcoming[position], listener)
    }

    override fun getItemCount(): Int = upcoming.size

}
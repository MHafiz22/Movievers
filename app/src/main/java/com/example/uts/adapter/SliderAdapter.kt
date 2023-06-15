package com.example.uts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.uts.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter (imageurl: ArrayList<String>):
    SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    var sliderimage:ArrayList<String> = imageurl

    override fun getCount(): Int {
        return sliderimage.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        var inflator:View = LayoutInflater.from(parent!!.context).inflate(R.layout.slideritem, null)
        return SliderViewHolder(inflator)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        if (viewHolder!=null)
            Glide.with(viewHolder.itemView).load(sliderimage.get(position)).fitCenter().into(viewHolder.imageview)
    }

    class SliderViewHolder(itemView : View):SliderViewAdapter.ViewHolder(itemView) {
        var imageview:ImageView=itemView.findViewById(R.id.myimage)

    }
}
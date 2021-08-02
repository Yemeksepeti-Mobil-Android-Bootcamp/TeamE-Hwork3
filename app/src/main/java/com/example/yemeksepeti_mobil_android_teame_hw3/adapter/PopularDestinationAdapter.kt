package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksepeti_mobil_android_teame_hw3.R

class PopularDestinationAdapter: RecyclerView.Adapter<PopularDestinationAdapter.PopularDestinationViewHolder>() {

    class PopularDestinationViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val imgPopularDestination: ImageView = view.findViewById(R.id.img_popular_destination)
        val titlePopularDestination: TextView = view.findViewById(R.id.title_popular_destination)
        fun setItem(img: Int, title: String?) {
           imgPopularDestination.setImageResource(img)
            titlePopularDestination.text = title
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularDestinationAdapter.PopularDestinationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_popular_destination, parent, false)
        return PopularDestinationViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PopularDestinationAdapter.PopularDestinationViewHolder,
        position: Int
    ) {
       holder.setItem(R.drawable.rome,"Rome")
       holder.setItem(R.drawable.rome,"Rome")
       holder.setItem(R.drawable.rome,"Rome")
    }

    override fun getItemCount(): Int = 3
}
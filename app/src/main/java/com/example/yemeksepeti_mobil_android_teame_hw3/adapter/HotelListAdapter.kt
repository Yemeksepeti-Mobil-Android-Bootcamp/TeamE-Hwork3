package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksepeti_mobil_android_teame_hw3.R

class HotelListAdapter: RecyclerView.Adapter<HotelListAdapter.HotelListViewHolder>() {
    class HotelListViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        var hotelImg : ImageView = view.findViewById(R.id.hotel_img)

        fun setItem(img: Int) {
            hotelImg.setImageResource(img)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HotelListAdapter.HotelListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_hotel_list, parent, false)
        return HotelListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelListAdapter.HotelListViewHolder, position: Int) {
        holder.setItem(R.drawable.hotel)
        holder.setItem(R.drawable.hotel)
        holder.setItem(R.drawable.hotel)
    }

    override fun getItemCount(): Int = 3
}
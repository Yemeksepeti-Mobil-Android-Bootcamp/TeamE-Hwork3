package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.AllHotelResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.CellHotelListBinding

class HotelListAdapter: RecyclerView.Adapter<HotelListAdapter.HotelListViewHolder>() {

    var hotelList : AllHotelResponse? = null

    class HotelListViewHolder(var binding: CellHotelListBinding) : RecyclerView.ViewHolder(binding.root){

        fun setItem(item: HotelData) {
            Glide.with(binding.root.context).load(item.imageUrl).placeholder(R.drawable.loading_animation).into(binding.hotelImg)
            binding.hotelName.text = item.name
            binding.hotelPrice.text = "$" + "${item.price}"
            binding.ratingbarHotel.numStars = item.star.toInt()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HotelListViewHolder {
        val view = CellHotelListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelListViewHolder, position: Int) {
        holder.setItem(hotelList?.data!![position])
    }

    override fun getItemCount(): Int = hotelList?.data?.size ?: 0
}
package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.common.CountryData
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.country.AllCountryResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.CellPopularDestinationBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource

class PopularDestinationAdapter: RecyclerView.Adapter<PopularDestinationAdapter.PopularDestinationViewHolder>() {

    var countryList : AllCountryResponse? = null

    class PopularDestinationViewHolder(var binding: CellPopularDestinationBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setItem(item: CountryData) {
            Glide.with(binding.root.context).load(item.imageUrl).placeholder(R.drawable.loading_animation).into(binding.imgPopularDestination)
            binding.titlePopularDestination.text = item.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularDestinationAdapter.PopularDestinationViewHolder {
        val view = CellPopularDestinationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularDestinationViewHolder(view)
    }


    override fun onBindViewHolder(
        holder: PopularDestinationAdapter.PopularDestinationViewHolder,
        position: Int
    ) {
        holder.setItem(countryList?.data!![position])

        //holder.setItem(R.drawable.rome,"Rome")
       //holder.setItem(R.drawable.rome,"Rome")
       //holder.setItem(R.drawable.rome,"Rome")
    }

    override fun getItemCount(): Int = countryList?.data?.size ?: 0
}
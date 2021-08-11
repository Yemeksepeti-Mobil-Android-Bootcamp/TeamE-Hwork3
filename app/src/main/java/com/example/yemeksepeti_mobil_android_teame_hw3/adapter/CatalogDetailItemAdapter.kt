package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.CatalogDetailItemBinding

class CatalogDetailItemAdapter: RecyclerView.Adapter<CatalogDetailItemAdapter.CatalogDetailItemViewHolder>() {
    var hotelList = ArrayList<HotelData>()

    class CatalogDetailItemViewHolder(var binding: CatalogDetailItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun setOnClickListener() {

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatalogDetailItemAdapter.CatalogDetailItemViewHolder {
        val view = CatalogDetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogDetailItemAdapter.CatalogDetailItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogDetailItemViewHolder, position: Int) {
        holder.binding.placeText.text = hotelList[position].name
        holder.binding.priceText.text = "$" + hotelList[position].price
        Glide.with(holder.binding.catalogImage.context).load(hotelList[position].imageUrl).into(holder.binding.catalogImage)
        holder.binding.btnHotelShow.setOnClickListener {
            val bundle = bundleOf("hotelId" to hotelList[position].id)
            it.findNavController().navigate(R.id.action_catalogDetailFragment_to_productFragment,bundle)
        }

    }

    override fun getItemCount(): Int{

        return hotelList.size
    }
}
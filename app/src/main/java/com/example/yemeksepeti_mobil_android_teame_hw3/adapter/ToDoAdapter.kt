package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.AllHotelResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.CellToDoBinding

class ToDoAdapter: RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    var hotelList : AllHotelResponse? = null

    class ToDoViewHolder(var binding: CellToDoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setItem(item: HotelData) {
            Glide.with(binding.root.context).load(item.imageUrl).placeholder(R.drawable.loading_animation).into(binding.imgToDo)
            binding.topToDoTitle.text = item.name
            binding.topToDoCountry.text = item.country.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoViewHolder {
        val view = CellToDoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ToDoViewHolder,
        position: Int
    ) {
        holder.setItem(hotelList?.data!![position])
        holder.binding.cellToDoLayout.setOnClickListener {
            val bundle = bundleOf("hotelId" to hotelList?.data!![position].id)
            var navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_homeFragment_to_fragmentProductDetail2, bundle)
        }
    }

    override fun getItemCount(): Int = hotelList?.data?.size ?: 0
}
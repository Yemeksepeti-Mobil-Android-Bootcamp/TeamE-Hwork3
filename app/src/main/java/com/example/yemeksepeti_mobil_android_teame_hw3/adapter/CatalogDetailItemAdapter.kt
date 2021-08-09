package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.CatalogDetailItemBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.CatalogItemBinding

class CatalogDetailItemAdapter: RecyclerView.Adapter<CatalogDetailItemAdapter.CatalogDetailItemViewHolder>() {

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
        holder.binding.btnHotelShow.setOnClickListener {
            it.findNavController().navigate(R.id.action_catalogDetailFragment_to_productFragment)
        }

    }

    override fun getItemCount(): Int = 3

}
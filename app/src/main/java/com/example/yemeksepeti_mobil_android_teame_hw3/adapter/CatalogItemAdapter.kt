package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.CatalogItemBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog_detail.CatalogDetailFragment


class CatalogItemAdapter(): RecyclerView.Adapter<CatalogItemAdapter.CatalogItemViewHolder>() {

    class CatalogItemViewHolder(var binding: CatalogItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatalogItemViewHolder {
        val view = CatalogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
       holder.binding.catalogItemBackground.setOnClickListener {
            it.findNavController().navigate(R.id.action_catalogFragment_to_catalogDetailFragment)
        }
    }

    override fun getItemCount(): Int = 10

}
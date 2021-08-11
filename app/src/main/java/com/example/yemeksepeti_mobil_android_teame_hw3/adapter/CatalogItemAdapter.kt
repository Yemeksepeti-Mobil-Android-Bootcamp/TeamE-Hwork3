package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.common.CountryData
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.CatalogItemBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog_detail.CatalogDetailFragment


class CatalogItemAdapter: RecyclerView.Adapter<CatalogItemAdapter.CatalogItemViewHolder>() {
    var countryList = ArrayList<CountryData>()

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
        holder.binding.catalogItemText.text = countryList[position].name
        Glide.with(holder.binding.catalogItemBackground.context).load(countryList[position].imageUrl).into(holder.binding.catalogItemBackground)


       holder.binding.catalogItemBackground.setOnClickListener {
           val bundle = bundleOf("countryId" to countryList[position].id)
            it.findNavController().navigate(R.id.action_catalogFragment_to_catalogDetailFragment,bundle)
        }
    }

    override fun getItemCount() : Int{

        return countryList.size
    }

}
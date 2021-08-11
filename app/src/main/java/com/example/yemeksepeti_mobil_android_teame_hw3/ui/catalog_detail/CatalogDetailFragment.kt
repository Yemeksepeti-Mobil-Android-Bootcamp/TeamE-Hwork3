package com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog_detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.CatalogDetailItemAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.common.CountryData
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentCatalogDetailBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog.CatalogViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogDetailFragment: Fragment() {


    private var adapter: CatalogDetailItemAdapter = CatalogDetailItemAdapter()
    private lateinit var _binding: FragmentCatalogDetailBinding
    private val viewModel: CatalogDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatalogDetailBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.catalogDetailRv.layoutManager = LinearLayoutManager(context)
        _binding.catalogDetailRv.adapter = adapter


        val countryId = arguments?.getString("countryId")
        Log.e("Catalog Detail",countryId!!)

        viewModel.hotelsByCountryId(countryId).observe(viewLifecycleOwner,{
            when (it.status)
            {
                Resource.Status.LOADING -> {
                    Log.e("Catalog fragment","Loading")

                }
                Resource.Status.SUCCESS -> {
                    Log.e("Catalog fragment","Succes")
                    adapter.hotelList = it.data!!.`data` as ArrayList<HotelData>
                    adapter.notifyDataSetChanged()


                }
                Resource.Status.ERROR -> {
                    Log.e("Catalog fragment","${it.message}")


                }


            }
        })
    }
}
package com.example.yemeksepeti_mobil_android_teame_hw3.ui.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentProductBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog_detail.CatalogDetailViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource

class ProductFragment: Fragment() {

    private lateinit var _binding: FragmentProductBinding

    private val viewModel: CatalogDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hotelId = arguments?.getString("hotelId")

        Log.e("HotelId",hotelId!!)

        _binding.btnMoreDetail.setOnClickListener {
            findNavController().navigate(R.id.action_productFragment_to_fragmentProductDetail)

            /*viewModel.hotelsByCountryId(countryId).observe(viewLifecycleOwner,{
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
            })*/
        }

    }
}
package com.example.yemeksepeti_mobil_android_teame_hw3.ui.product_detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentProductDetailBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentProductDetail: Fragment() {

    private lateinit var _binding: FragmentProductDetailBinding
    private val viewModel: ProductDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return _binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val hotelId = arguments?.getString("hotelId")
        super.onViewCreated(view, savedInstanceState)
        if (hotelId != null) {
            viewModel.getHotelDatabyId(hotelId).observe(viewLifecycleOwner, {
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        val hotelData = it.data!!.hotelByIdData
                        val hotelStar = hotelData.star + ".0"
                        _binding.productDetailHotelName.text = hotelData.name
                        _binding.productDetailHotelDescription.text = hotelData.description
                        _binding.productDetailHotelPrice.text = "$${hotelData.price} "
                        _binding.productDetailHotelPoint.text = hotelStar
                        Glide.with(_binding.root.context).load(hotelData.imageUrl).into(_binding.productDetailBackground)
                    }
                }
            })
        }
    }
}
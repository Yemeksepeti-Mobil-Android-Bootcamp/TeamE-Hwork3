package com.example.yemeksepeti_mobil_android_teame_hw3.ui.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentProductBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog_detail.CatalogDetailViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment: Fragment() {

    private lateinit var _binding: FragmentProductBinding

    private val viewModel: ProductViewModel by viewModels()

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



            viewModel.hotelsById(hotelId).observe(viewLifecycleOwner,{
                when (it.status)
                {
                    Resource.Status.LOADING -> {
                        Log.e("Product fragment","Loading")

                    }
                    Resource.Status.SUCCESS -> {
                        Log.e("Product fragment", "Succes")

                        _binding.hotelName.text = it.data!!.hotelByIdData.name
                        _binding.location.text = it.data!!.hotelByIdData.location
                        _binding.price.text = "$"+it.data!!.hotelByIdData.price
                       Glide.with(_binding.productLayout.context).load(it.data!!.hotelByIdData.imageUrl).into(_binding.productBackground)
                       _binding.ratingbar.numStars = it.data!!.hotelByIdData.star.toInt()
                        _binding.btnMoreDetail.setOnClickListener {
                            val bundle = bundleOf("hotelId" to hotelId)
                            findNavController().navigate(R.id.action_productFragment_to_fragmentProductDetail,bundle)


                        }
                    }
                    Resource.Status.ERROR -> {
                        Log.e("Product fragment","${it.message}")


                    }


                }
            })
        }

    }

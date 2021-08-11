package com.example.yemeksepeti_mobil_android_teame_hw3.ui.product_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.data.TravelApiRepository
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.hotel.HotelByIdResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    val apiRepository: TravelApiRepository
) : ViewModel(){

    fun getHotelDatabyId(hotelId : String) : LiveData<Resource<HotelByIdResponse>>{
        return(apiRepository.getHotelById(hotelId))
    }

}
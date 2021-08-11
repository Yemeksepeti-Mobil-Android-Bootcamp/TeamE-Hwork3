package com.example.yemeksepeti_mobil_android_teame_hw3.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.data.TravelApiRepository
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelByCountryListResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.hotel.HotelByIdResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor (
    var savedStateHandle: SavedStateHandle,
    var travelApiRepository: TravelApiRepository
) : ViewModel()
{
    fun hotelsById( hotelId: String) : LiveData<Resource<HotelByIdResponse>> {
        return travelApiRepository.getHotelById(hotelId)

    }

}
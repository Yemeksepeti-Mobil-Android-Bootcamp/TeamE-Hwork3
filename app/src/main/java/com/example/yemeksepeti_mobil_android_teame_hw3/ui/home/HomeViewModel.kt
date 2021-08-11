package com.example.yemeksepeti_mobil_android_teame_hw3.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.data.TravelApiRepository
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.country.AllCountryResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.AllHotelResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    var travelApiRepository: TravelApiRepository
): ViewModel()  {

    fun getAllCountryList() : LiveData<Resource<AllCountryResponse>> = travelApiRepository.getAllCountryList()

    fun getAllHotel() : LiveData<Resource<AllHotelResponse>> = travelApiRepository.getAllHotels()
}
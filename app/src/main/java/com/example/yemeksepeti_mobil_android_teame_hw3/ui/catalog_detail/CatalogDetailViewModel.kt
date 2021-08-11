package com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.data.TravelApiRepository
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelByCountryListResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class CatalogDetailViewModel  @Inject constructor (
    var savedStateHandle: SavedStateHandle,
    var travelApiRepository: TravelApiRepository
) : ViewModel()
{
    fun hotelsByCountryId(countryId : String) : LiveData<Resource<HotelByCountryListResponse>> {
        return travelApiRepository.getHotelsByCountryId(countryId)

    }


}
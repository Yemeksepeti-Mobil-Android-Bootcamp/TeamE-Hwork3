package com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.data.TravelApiRepository
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.country.AllCountryResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class CatalogViewModel @Inject constructor (
    var savedStateHandle: SavedStateHandle,
    var travelApiRepository: TravelApiRepository) : ViewModel()
{
    fun countryList() : LiveData<Resource<AllCountryResponse>> {
        return travelApiRepository.getAllCountryList()
    }


}
package com.example.yemeksepeti_mobil_android_teame_hw3.data.remote

import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.login.LoginRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.register.RegisterRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.util.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val travelApiService: TravelApiService
): BaseDataSource() {

    suspend fun login(request: LoginRequest) = getResult { travelApiService.login(request) }

    suspend fun register(request: RegisterRequest) = getResult { travelApiService.register(request) }

    suspend fun getAllCountryList() = getResult { travelApiService.getAllCountryList() }

    suspend fun getHotelsByCountryId(countryId : String) = getResult { travelApiService.getHotelsByCountryId(countryId) }

    suspend fun getHotelById(hotelId : String) = getResult { travelApiService.getHotelById(hotelId) }

    suspend fun getAllHotels() = getResult { travelApiService.getAllHotels() }
}
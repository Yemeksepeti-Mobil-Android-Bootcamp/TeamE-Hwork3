package com.example.yemeksepeti_mobil_android_teame_hw3.data.remote

import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.country.AllCountryResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.AllHotelResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelByCountryListResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.login.LoginRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.login.LoginResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.register.RegisterRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TravelApiService {
    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest) : Response<LoginResponse>

    @POST("api/auth/register")
    suspend fun register(@Body request: RegisterRequest) : Response<RegisterResponse>

    @GET("api/e/country")
    suspend fun getAllCountryList() : Response<AllCountryResponse>

    @GET("api/e/country/{countryId}/hotel")
    suspend fun getHotelsByCountryId(@Path("countryId") countryId : String) : Response<HotelByCountryListResponse>

    @GET("api/e/hotel/{hotelId}")
    suspend fun getHotelById(@Path("hotelId") hotelId : String) : Response<HotelData>

    @GET("api/e/hotel")
    suspend fun getAllHotels() : Response<AllHotelResponse>
}
package com.example.yemeksepeti_mobil_android_teame_hw3.data.remote

import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.country.AllCountryResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.AllHotelResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelByCountryListResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.HotelData
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.hotel.HotelByIdResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.login.LoginRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.login.LoginResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.register.RegisterRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.register.RegisterResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user.UserRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user.UserResponse
import retrofit2.Response
import retrofit2.http.*

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
    suspend fun getHotelById(@Path("hotelId") hotelId : String) : Response<HotelByIdResponse>

    @GET("api/e/hotel")
    suspend fun getAllHotels() : Response<AllHotelResponse>

    @GET("api/auth/profile")
    suspend fun getUserData(@Header("Authorization") Authorization: String) : Response<UserResponse>
}
package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.hotel


import com.google.gson.annotations.SerializedName

data class HotelByIdResponse(
    @SerializedName("data")
    val hotelByIdData: HotelByIdData,
    @SerializedName("success")
    val success: Boolean
)
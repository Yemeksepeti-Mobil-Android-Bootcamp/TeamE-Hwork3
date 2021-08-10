package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels


import com.google.gson.annotations.SerializedName

data class AllHotelResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("data")
    val `data`: List<HotelData>,
    @SerializedName("success")
    val success: Boolean
)
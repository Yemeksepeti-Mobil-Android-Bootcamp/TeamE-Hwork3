package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.country


import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.common.CountryData
import com.google.gson.annotations.SerializedName

data class AllHotelResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("data")
    val `data`: List<CountryData>,
    @SerializedName("success")
    val success: Boolean
)
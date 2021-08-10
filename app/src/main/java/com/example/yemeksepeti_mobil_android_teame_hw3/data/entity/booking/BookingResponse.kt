package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.booking


import com.google.gson.annotations.SerializedName

data class BookingResponse(
    @SerializedName("data")
    val bookingData: BookingData,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)
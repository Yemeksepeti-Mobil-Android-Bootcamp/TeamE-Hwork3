package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.booking


import com.google.gson.annotations.SerializedName

data class BookingRequest(
    @SerializedName("isBooking")
    val isBooking: Boolean
)
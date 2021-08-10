package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.booking


import com.google.gson.annotations.SerializedName

data class BookingData(
    @SerializedName("createdDate")
    val createdDate: String,
    @SerializedName("hotel")
    val hotel: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isBooking")
    val isBooking: Boolean,
    @SerializedName("__v")
    val v: Int
)
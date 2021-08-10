package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels


import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.common.CountryData
import com.google.gson.annotations.SerializedName

data class HotelData(
    @SerializedName("country")
    val country: CountryData,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("star")
    val star: String,
    @SerializedName("user")
    val user: String,
    @SerializedName("__v")
    val v: Int
)
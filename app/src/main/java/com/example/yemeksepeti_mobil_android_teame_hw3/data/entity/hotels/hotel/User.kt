package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.hotel


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String
)
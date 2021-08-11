package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user


import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    val `data`: UserData,
    @SerializedName("success")
    val success: Boolean
)
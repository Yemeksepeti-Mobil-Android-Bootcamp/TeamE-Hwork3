package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.login


import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.common.Data
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("token")
    val token: String
)
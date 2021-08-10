package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.login


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
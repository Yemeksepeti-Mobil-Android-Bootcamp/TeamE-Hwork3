package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user


import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("blocked")
    val blocked: Boolean,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("dennes")
    val dennes: List<Any>,
    @SerializedName("email")
    val email: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("orders")
    val orders: List<Any>,
    @SerializedName("profile_image")
    val profileImage: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("__v")
    val v: Int
)
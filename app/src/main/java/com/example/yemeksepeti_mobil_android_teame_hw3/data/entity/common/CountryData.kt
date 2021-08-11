package com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.common


import com.google.gson.annotations.SerializedName

data class CountryData(
    @SerializedName("createdAt")
    val createdAt: String,
    //@SerializedName("hotels")
    //val hotels: List<String>,
    @SerializedName("_id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("user")
    val user: String,
    @SerializedName("__v")
    val v: Int
)
package com.example.yemeksepeti_mobil_android_teame_hw3.data.remote

import com.example.yemeksepeti_mobil_android_teame_hw3.util.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val travelApiService: TravelApiService
): BaseDataSource() {
}
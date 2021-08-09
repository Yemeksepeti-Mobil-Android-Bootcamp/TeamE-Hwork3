package com.example.yemeksepeti_mobil_android_teame_hw3.data

import com.example.yemeksepeti_mobil_android_teame_hw3.data.local.LocaleDataSource
import com.example.yemeksepeti_mobil_android_teame_hw3.data.remote.RemoteDataSource
import javax.inject.Inject

class TravelApiRepository @Inject constructor(
    private var remoteDataSource: RemoteDataSource,
    private var localeDataSource: LocaleDataSource

) {
}
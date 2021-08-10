package com.example.yemeksepeti_mobil_android_teame_hw3.data.local

import javax.inject.Inject

class LocaleDataSource @Inject constructor(
    val sharedPrefManager: SharedPrefManager
) {

    fun saveToken(token: String) {
        sharedPrefManager.saveToken(token)
    }

    fun getToken(): String? {
        return sharedPrefManager.getToken()
    }
}

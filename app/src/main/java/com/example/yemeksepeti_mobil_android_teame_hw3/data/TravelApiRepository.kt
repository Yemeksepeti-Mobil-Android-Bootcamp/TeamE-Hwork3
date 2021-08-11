package com.example.yemeksepeti_mobil_android_teame_hw3.data

import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.login.LoginRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.register.RegisterRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user.UserRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.local.LocaleDataSource
import com.example.yemeksepeti_mobil_android_teame_hw3.data.remote.RemoteDataSource
import com.example.yemeksepeti_mobil_android_teame_hw3.util.performAuthTokenNetworkOperation
import com.example.yemeksepeti_mobil_android_teame_hw3.util.performNetworkOperation
import javax.inject.Inject

class TravelApiRepository @Inject constructor(
    private var remoteDataSource: RemoteDataSource,
    private var localeDataSource: LocaleDataSource

) {
    fun login(loginRequest: LoginRequest) = performAuthTokenNetworkOperation(
        call = {
            remoteDataSource.login(loginRequest)
        },
        save = {
            localeDataSource.saveToken(it)
        }
    )
    fun signOut() = localeDataSource.saveToken("")

    fun checkToken(): String? {
        return localeDataSource.getToken()
    }
    fun saveToken(token:String) = localeDataSource.saveToken(token)

    fun register(registerRequest: RegisterRequest) = performNetworkOperation {
        remoteDataSource.register(registerRequest)
    }

    fun getAllCountryList() = performNetworkOperation {
        remoteDataSource.getAllCountryList()
    }

    fun getHotelsByCountryId(countryId : String) = performNetworkOperation {
        remoteDataSource.getHotelsByCountryId(countryId)
    }

    fun getHotelById(hotelId : String) = performNetworkOperation {
        remoteDataSource.getHotelById(hotelId)
    }

    fun getAllHotels() = performNetworkOperation {
        remoteDataSource.getAllHotels()
    }

    fun getUserData(Authorization: String) = performNetworkOperation {
        remoteDataSource.getUserData(Authorization)
    }
}
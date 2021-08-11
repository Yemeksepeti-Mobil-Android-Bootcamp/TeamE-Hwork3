package com.example.yemeksepeti_mobil_android_teame_hw3.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.data.TravelApiRepository
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user.UserRequest
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user.UserResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    var apiRepository: TravelApiRepository
) : ViewModel() {
    val userData: MutableLiveData<Resource<UserResponse>> = MutableLiveData()

    fun getUserData() : LiveData<Resource<UserResponse>> {
        userData.postValue(Resource.loading())
        val request = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxMTI5NzM0YjNhYzU0MDAxNTY4MTc4YyIsIm5hbWUiOiJDdW5leXQgRXl1Ym9nbHUiLCJpYXQiOjE2Mjg2NzI0MDgsImV4cCI6MTYyODY5MDQwOH0.9QrnovN5NLLvMqIoQ5wuWQo-HLvGFkCJGSNTYg1cqdI"
        return (apiRepository.getUserData(request))
    }

}
package com.example.yemeksepeti_mobil_android_teame_hw3.ui.profile

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksepeti_mobil_android_teame_hw3.activity.StartActivity
import com.example.yemeksepeti_mobil_android_teame_hw3.data.TravelApiRepository
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user.UserResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    var apiRepository: TravelApiRepository
) : ViewModel() {

    fun getUserData() : LiveData<Resource<UserResponse>> {
        val request = getToken()
        return (apiRepository.getUserData(request))
    }
    fun getToken() : String{
        apiRepository.checkToken()?.let {
            return(it)
        }
        return("no token provided")
    }

    fun signOut(): Boolean {
        apiRepository.signOut()
        return(true)
    }

}
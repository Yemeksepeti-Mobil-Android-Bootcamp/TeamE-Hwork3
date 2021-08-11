package com.example.yemeksepeti_mobil_android_teame_hw3.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.yemeksepeti_mobil_android_teame_hw3.activity.StartActivity
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.hotel.User
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user.UserData
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.user.UserResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.local.SharedPrefManager
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentProfileBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
class ProfileFragment: Fragment() {
    private lateinit var _binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserData().observe(viewLifecycleOwner, {
            when(it.status){
                Resource.Status.SUCCESS -> {
                    val userResponse = UserResponse(it.data!!.data,it.data.success)
                    val userData = userResponse.data
                    val userNameString = userData.name[0].toString() + userData.name.substringAfterLast(" ").lowercase()
                    _binding.nameTextView.text = userData.name
                    _binding.emailTextView.text = userData.email
                    _binding.usernameTextView.text = userNameString
                    _binding.profileLoadingBar.visibility = View.GONE
                    //Phone-Birthday-Address textviewlar dummy data ile dolu
                }
            }
        })
        _binding.btnSignOut.setOnClickListener{
            if(viewModel.signOut()){
                activity?.let{
                    val intent = Intent(it, StartActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                    startActivity(intent)
                    it.finish()
                }
            }
        }
    }
}
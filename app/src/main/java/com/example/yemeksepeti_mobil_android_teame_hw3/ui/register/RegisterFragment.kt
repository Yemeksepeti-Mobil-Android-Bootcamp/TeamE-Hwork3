package com.example.yemeksepeti_mobil_android_teame_hw3.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.yemeksepeti_mobil_android_teame_hw3.MainActivity
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentSignupBinding

class RegisterFragment: Fragment() {
    private lateinit var _binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.btnSignUp.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
            //activity?.finish()
            //findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
        }
    }
}
package com.example.yemeksepeti_mobil_android_teame_hw3.ui.start2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentStartScreenTwoBinding

class Start2Fragment: Fragment() {
    private lateinit var _binding: FragmentStartScreenTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartScreenTwoBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_start2Fragment_to_loginFragment)
        }

        _binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_start2Fragment_to_registerFragment)
        }
    }
}
package com.example.yemeksepeti_mobil_android_teame_hw3.ui.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentProductDetailBinding


class FragmentProductDetail: Fragment() {

    private lateinit var _binding: FragmentProductDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return _binding.root
    }
}
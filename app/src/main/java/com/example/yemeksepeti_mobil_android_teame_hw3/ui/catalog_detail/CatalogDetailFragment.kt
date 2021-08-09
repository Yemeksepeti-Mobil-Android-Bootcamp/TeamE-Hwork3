package com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.CatalogDetailItemAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentCatalogDetailBinding


class CatalogDetailFragment: Fragment() {

    private var adapter: CatalogDetailItemAdapter = CatalogDetailItemAdapter()
    private lateinit var _binding: FragmentCatalogDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatalogDetailBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.catalogDetailRv.layoutManager = LinearLayoutManager(context)
        _binding.catalogDetailRv.adapter = adapter
    }
}
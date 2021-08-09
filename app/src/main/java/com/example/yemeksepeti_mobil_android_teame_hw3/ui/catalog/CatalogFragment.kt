package com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.CatalogItemAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentCatalogRecyclerBinding

class CatalogFragment: Fragment() {

    private var adapter: CatalogItemAdapter = CatalogItemAdapter()
    private lateinit var _binding: FragmentCatalogRecyclerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatalogRecyclerBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        _binding.recyclerView.layoutManager = LinearLayoutManager(context)
        _binding.recyclerView.adapter = adapter
    }
}
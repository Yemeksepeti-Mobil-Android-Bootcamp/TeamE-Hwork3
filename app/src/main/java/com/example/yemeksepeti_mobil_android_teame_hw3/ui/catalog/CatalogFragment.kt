package com.example.yemeksepeti_mobil_android_teame_hw3.ui.catalog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.CatalogItemAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.common.CountryData
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentCatalogRecyclerBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment: Fragment() {

    private var adapter = CatalogItemAdapter()
    private lateinit var _binding: FragmentCatalogRecyclerBinding
    private val viewModel: CatalogViewModel by viewModels()


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
        viewModel.countryList().observe(viewLifecycleOwner,{
            when (it.status)
            {
                Resource.Status.LOADING -> {
                    Log.e("Catalog fragment","Loading")

                }
                Resource.Status.SUCCESS -> {
                    Log.e("Catalog fragment","Succes")
                    adapter.countryList = it.data!!.`data` as ArrayList<CountryData>
                    adapter.notifyDataSetChanged()


                }
                Resource.Status.ERROR -> {
                    Log.e("Catalog fragment","${it.message}")


                }


            }
        })
    }

    private fun initAdapter() {
        _binding.recyclerView.layoutManager = LinearLayoutManager(context)
        _binding.recyclerView.adapter = adapter
    }
}
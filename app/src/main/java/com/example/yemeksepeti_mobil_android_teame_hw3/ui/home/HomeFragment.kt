package com.example.yemeksepeti_mobil_android_teame_hw3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.HotelListAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.PopularDestinationAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.ToDoAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.country.AllCountryResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.hotels.AllHotelResponse
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentCatalogDetailBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.databinding.FragmentHomeBinding
import com.example.yemeksepeti_mobil_android_teame_hw3.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    lateinit var popularDestinationRv: RecyclerView
    lateinit var toDoRv: RecyclerView
    lateinit var hotelListRv: RecyclerView
    private var popularDestinationAdapter: PopularDestinationAdapter = PopularDestinationAdapter()
    private var toDoAdapter: ToDoAdapter = ToDoAdapter()
    private var hotelListAdapter: HotelListAdapter = HotelListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularDestinationRv = view.findViewById(R.id.popular_destination_rv)
        popularDestinationRv.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL, false)
        popularDestinationRv.adapter = popularDestinationAdapter

        viewModel.getAllCountryList().observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Resource.Status.LOADING -> {
                    _binding.homescrollview.visibility = View.GONE

                }

                Resource.Status.SUCCESS -> {
                    _binding.homeLoadingBar.visibility = View.GONE
                    _binding.homescrollview.visibility = View.VISIBLE
                    popularDestinationAdapter.countryList = it.data as AllCountryResponse
                    popularDestinationAdapter.notifyDataSetChanged()
                }

                Resource.Status.ERROR -> {

                }
            }


        })


        toDoRv = view.findViewById(R.id.to_do_rv)
        toDoRv.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL, false)
        toDoRv.adapter = toDoAdapter

        viewModel.getAllHotel().observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Resource.Status.LOADING -> {


                }

                Resource.Status.SUCCESS -> {
                    toDoAdapter.hotelList = it.data as AllHotelResponse
                    toDoAdapter.notifyDataSetChanged()
                }

                Resource.Status.ERROR -> {

                }
            }

        })

        hotelListRv = view.findViewById(R.id.hotel_list_rv)
        hotelListRv.layoutManager = LinearLayoutManager(context)
        hotelListRv.adapter = hotelListAdapter

        viewModel.getAllHotel().observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Resource.Status.LOADING -> {


                }

                Resource.Status.SUCCESS -> {
                    hotelListAdapter.hotelList = it.data as AllHotelResponse
                    hotelListAdapter.notifyDataSetChanged()
                }

                Resource.Status.ERROR -> {

                }
            }

        })
    }

}
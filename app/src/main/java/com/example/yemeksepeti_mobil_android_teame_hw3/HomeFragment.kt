package com.example.yemeksepeti_mobil_android_teame_hw3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.HotelListAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.PopularDestinationAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.ToDoAdapter

class HomeFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularDestinationRv = view.findViewById(R.id.popular_destination_rv)
        popularDestinationRv.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL, false)
        popularDestinationRv.adapter = popularDestinationAdapter

        toDoRv = view.findViewById(R.id.to_do_rv)
        toDoRv.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL, false)
        toDoRv.adapter = toDoAdapter

        hotelListRv = view.findViewById(R.id.hotel_list_rv)
        hotelListRv.layoutManager = LinearLayoutManager(context)
        hotelListRv.adapter = hotelListAdapter
    }

}
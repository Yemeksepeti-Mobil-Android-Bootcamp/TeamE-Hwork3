package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksepeti_mobil_android_teame_hw3.R

class ToDoAdapter: RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class ToDoViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val imgPopularDestination: ImageView = view.findViewById(R.id.img_popular_destination)
        val titleToDo: TextView = view.findViewById(R.id.top_to_do_title)
        val countryToDo: TextView = view.findViewById(R.id.top_to_do_country)
        fun setItem(img: Int, title: String, country: String?) {
            imgPopularDestination.setImageResource(img)
            titleToDo.text = title
            countryToDo.text = country
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoAdapter.ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_to_do, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ToDoAdapter.ToDoViewHolder,
        position: Int
    ) {
        holder.setItem(R.drawable.todo,"Hunt with eagle in\nAltai Mountains","Ulgii, Mongolia")
        holder.setItem(R.drawable.todo,"Hunt with eagle in\nAltai Mountains","Ulgii, Mongolia")
        holder.setItem(R.drawable.todo,"Hunt with eagle in\nAltai Mountains","Ulgii, Mongolia")
    }

    override fun getItemCount(): Int = 3
}
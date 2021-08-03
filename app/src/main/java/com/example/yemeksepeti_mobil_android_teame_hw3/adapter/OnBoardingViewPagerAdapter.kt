package com.example.yemeksepeti_mobil_android_teame_hw3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.model.OnBoardingData

class OnBoardingViewPagerAdapter(private var context: Context, private  var onBoardingDataList: List<OnBoardingData>) : PagerAdapter() {
    var btnBack: ImageButton? = null
    var btnGetStarted: Button? = null

    override fun getCount(): Int = onBoardingDataList.size + 1

    override fun isViewFromObject(view: View, `object`: Any): Boolean = (view == `object`)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(context).inflate(R.layout.onboarding_layout, null)

        if(position == onBoardingDataList.size){
            view = LayoutInflater.from(context).inflate(R.layout.onboarding_layout_last,null)
            btnBack= view.findViewById(R.id.btn_back)
            btnGetStarted = view.findViewById(R.id.btn_get_started)
        }else {
            val imageView: ImageView = view.findViewById(R.id.onBoarding_image)
            val title: TextView = view.findViewById(R.id.title)
            val description: TextView = view.findViewById(R.id.description)

            imageView.setImageResource(onBoardingDataList[position].imgUrl)
            title.text = onBoardingDataList[position].title
            description.text = onBoardingDataList[position].description
        }

        container.addView(view)

        return view
    }
}
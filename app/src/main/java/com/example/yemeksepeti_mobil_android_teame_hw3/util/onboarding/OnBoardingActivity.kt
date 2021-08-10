package com.example.yemeksepeti_mobil_android_teame_hw3.util.onboarding

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.example.yemeksepeti_mobil_android_teame_hw3.MainActivity
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.StartActivity
import com.example.yemeksepeti_mobil_android_teame_hw3.adapter.OnBoardingViewPagerAdapter
import com.example.yemeksepeti_mobil_android_teame_hw3.model.OnBoardingData
import com.google.android.material.tabs.TabLayout

class OnBoardingActivity : AppCompatActivity() {
    var viewPagerAdapter: OnBoardingViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager: ViewPager? = null
    var nextBtn: ImageButton? = null
    var position = 0
    var sharedPreferences: SharedPreferences? = null
    val onBoardingDataList: MutableList<OnBoardingData> = ArrayList()
    var relativeLayout: RelativeLayout? = null
    var touchableList: ArrayList<View>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //We call this function because we need to check if the application is opened for the first time.
        //If isFirstTimeRun = true -> navigate to home page
        //If isFirstTimeRun = false -> continue this page
        if(restorePrefData()) {
            val intent = Intent(applicationContext, StartActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContentView(R.layout.activity_onboarding)

        initViews()

        initOnBoardingData()

        manageTabLayout()
    }

    private fun initViews() {
        tabLayout = findViewById(R.id.tab_indicator)
        nextBtn = findViewById(R.id.next_btn)
        relativeLayout = findViewById(R.id.tab_layout)
    }

    private fun initOnBoardingData() {
        onBoardingDataList.add(OnBoardingData("Get inspiration\n for your next trip",
            R.drawable.onboarding_1, "We’re happy to share our best tips for\n destinations where you can relax. But you\n find the nicest city trips as well!"))
        onBoardingDataList.add(OnBoardingData("Find best place\n for your journey",
            R.drawable.onboarding_2, "We’re happy to share our best tips for\n destinations where you can relax. But you\n find the nicest city trips as well!"))

        setOnBoardingViewPagerAdapter(onBoardingDataList)
    }

    private fun manageTabLayout() {
        disableTabLayout()

        //To assign value to the position we need to get the current index of the view pager
        position = onBoardingViewPager!!.currentItem

        //To move with button in viewpager
        nextBtn?.setOnClickListener {
            //If the position is less than the list length, the position is increased and the current index of the viewpager needs to be updated.
            if(position < onBoardingDataList.size) {
                position++
                onBoardingViewPager!!.currentItem = position
            }

            //If the end of the list is reached, it will be redirected to the home page
            if(position == onBoardingDataList.size) {
                //We are calling this function because we need to record that the onBoarding screen is called for the first time.
                //Otherwise we will see the onboarding screen every time the app is opened.
                relativeLayout?.visibility= View.GONE
                btnBackOnClickListener()
                btnGetStartedListener()
            }
        }

    }

    private fun disableTabLayout() {
        touchableList = tabLayout?.touchables
        touchableList?.forEach { it.isEnabled = false }
    }

    private fun btnGetStartedListener() {
        viewPagerAdapter?.btnGetStarted?.setOnClickListener {
            savePrefData()
            val intent = Intent(applicationContext, StartActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun btnBackOnClickListener() {
        viewPagerAdapter?.btnBack?.setOnClickListener {
            position--
            onBoardingViewPager!!.currentItem = position
            relativeLayout?.visibility= View.VISIBLE
        }
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingDataList: List<OnBoardingData>) {
        onBoardingViewPager = findViewById<ViewPager>(R.id.onboarding_view_pager)
        viewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingDataList)
        onBoardingViewPager!!.adapter = viewPagerAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)
    }

    private fun savePrefData() {
        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }

    private fun restorePrefData() : Boolean{
        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)
    }
}
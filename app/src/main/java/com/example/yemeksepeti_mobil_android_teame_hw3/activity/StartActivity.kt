package com.example.yemeksepeti_mobil_android_teame_hw3.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import com.example.yemeksepeti_mobil_android_teame_hw3.R
import com.example.yemeksepeti_mobil_android_teame_hw3.data.local.SharedPrefManager

@AndroidEntryPoint

class StartActivity : AppCompatActivity() {

    private fun getToken() : String?{
        return SharedPrefManager(applicationContext).getToken()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        if(!getToken().isNullOrEmpty()){
            Log.v("token kontrol",getToken().toString())
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            super.finish()
            finish()
        }
    }
}
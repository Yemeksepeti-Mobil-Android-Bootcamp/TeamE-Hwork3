package com.example.yemeksepeti_mobil_android_teame_hw3.di

import android.content.Context
import com.example.yemeksepeti_mobil_android_teame_hw3.data.local.LocaleDataSource
import com.example.yemeksepeti_mobil_android_teame_hw3.data.local.SharedPrefManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityRetainedComponent::class)
class DatabaseModule {

    @Provides
    fun sharedPrefManager(@ApplicationContext context: Context): SharedPrefManager {
        return SharedPrefManager(context)
    }

    @Provides
    fun localDataSource(sharedPrefManager: SharedPrefManager): LocaleDataSource {
        return LocaleDataSource(sharedPrefManager)
    }
}

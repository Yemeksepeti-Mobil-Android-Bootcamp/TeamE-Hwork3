package com.example.yemeksepeti_mobil_android_teame_hw3.di

import androidx.viewbinding.BuildConfig
import com.example.yemeksepeti_mobil_android_teame_hw3.data.entity.common.Endpoint
import com.example.yemeksepeti_mobil_android_teame_hw3.data.remote.RemoteDataSource
import com.example.yemeksepeti_mobil_android_teame_hw3.data.remote.TravelApiService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkTravelModule {

    @Provides
    fun provideTravelApiService(retrofit: Retrofit): TravelApiService{
        return retrofit.create(TravelApiService::class.java)
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        endPoint: Endpoint
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endPoint.url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.interceptors().add(HttpLoggingInterceptor().apply {
            level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        return builder.build()
    }

    @Provides
    fun provideEndpoint(): Endpoint {
        //https://rickandmortyapi.com/api/
        return Endpoint("https://dist-learn.herokuapp.com/api/")
    }

    @Provides
    fun provideRemoteDataSource(
        apiService: TravelApiService,
    ): RemoteDataSource {
        return RemoteDataSource(apiService)
    }
}


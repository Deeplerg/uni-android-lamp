package com.example.somelesson.di

import com.example.somelesson.data.LampService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
object NetworkModule {

    @Provides
    fun provideLampService() : LampService {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

         return Retrofit.Builder()
                .baseUrl("http://195.133.53.179:1337/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create()
    }

}
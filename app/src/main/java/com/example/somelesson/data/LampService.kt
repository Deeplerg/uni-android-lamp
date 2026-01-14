package com.example.somelesson.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LampService {

    @POST("state/on")
    suspend fun turnOn(): Response<Boolean>

    @POST("state/off")
    suspend fun turnOff(): Response<Boolean>

    @POST("color")
    suspend fun setColor(@Query("color") color: String): Response<Boolean>

    @GET
    suspend fun getBrightness()
}
package com.example.somelesson.data

import retrofit2.Response
import javax.inject.Inject

interface LampRepository {
    suspend fun setState(isOn: Boolean): Boolean
    suspend fun setColor(string: String): Boolean
}

class LampRepositoryImpl @Inject constructor(
    private val service: LampService,
): LampRepository {
    override suspend fun setState(isOn: Boolean): Boolean {
        try {
            var response: Response<Boolean>
            if (isOn)
                response = service.turnOn()
            else
                response = service.turnOff()

            return response.isSuccessful
        }
        catch(e: Exception) {
            println(e)
            return false
        }
    }

    override suspend fun setColor(color: String): Boolean {
        try {
            val response = service.setColor(color)

            return response.isSuccessful
        }
        catch (e: Exception) {
            println(e)
            return false
        }
    }
}
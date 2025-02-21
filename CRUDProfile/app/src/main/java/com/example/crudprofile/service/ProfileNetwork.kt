package com.example.crudprofile.service

import android.util.Log
import com.example.crudprofile.model.PeopleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

class ProfileNetwork {
    private val baseUrls = "https://.....mockapi.io/"
    suspend fun getProfile(): List<PeopleModel> {
        return withContext(Dispatchers.IO) {
            val api = Retrofit.Builder()
                .baseUrl(baseUrls)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)

            val response = api.getProfileAll()
            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                throw Exception("Error: ${response.code()}")
            }
        }
    }

    suspend fun updateProfile(data: PeopleModel) = withContext(Dispatchers.IO) {
        val api = Retrofit.Builder()
            .baseUrl(baseUrls)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        val response = api.updateProfile(data.id, data)
        if (response.code() == 200) {
            true
        } else {
            false
            throw Exception("Error: ${response.code()}")

        }
    }

    suspend fun deleteProfile(id: String) = withContext(Dispatchers.IO) {
        val api = Retrofit.Builder()
            .baseUrl(baseUrls)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        val response = api.deleteProfile(id)
        if (response.code() == 200){
            true
        }else{

            throw Exception("Error Delete Profile Code: ${response.code()}")
        }
    }
}

// Update API interface
interface MyApi {
    @GET("People")
    suspend fun getProfileAll(): Response<List<PeopleModel>>

    @PUT("People/{id}")
    suspend fun updateProfile(
        @Path("id") id: String,
        @Body profile: PeopleModel
    ): Response<PeopleModel>

    @DELETE("People/{id}")
    suspend fun deleteProfile(@Path("id") id: String) : Response<Unit>

}
package com.example.myapplication

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("mensagens")
    suspend fun saveData(@Body data: DataModel): Response<DataModel>

    @GET("mensagens")
    suspend fun getData(): Response<List<DataModel>>

}

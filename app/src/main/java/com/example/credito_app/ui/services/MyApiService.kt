package com.example.credito_app.ui.services

import retrofit2.Response
import retrofit2.http.GET

data class Data(
    val nombre: String,
    val precio: Int
)

interface MyApiService {
    @GET("creditos/all")
    suspend fun getData(): Response<List<Data>>
}
package com.nipun.saveo_assignment.model.network


import com.nipun.saveo_assignment.model.response.ResponseModelItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("shows")
    suspend fun getShows(@Query("page") topic: Int): List<ResponseModelItem>
}
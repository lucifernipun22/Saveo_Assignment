package com.nipun.saveo_assignment.model.network



import com.nipun.saveo_assignment.model.ResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("shows")
    suspend fun getShows(@Query("page") topic: String): List<ResponseItem>
}
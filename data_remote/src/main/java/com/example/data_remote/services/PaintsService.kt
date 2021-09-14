package com.example.data_remote.services

import com.example.data_remote.response.PaintResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PaintsService {

    @GET("collection?imgonly")
    suspend fun loadPaints(
        @Query("p") page: Int
    ): PaintResponse

}
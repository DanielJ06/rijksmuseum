package com.example.data_remote.services

import com.example.data_remote.response.CollectionsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CollectionsService {

    @GET("collections?imgonly")
    suspend fun loadCollections(): Response<CollectionsResponse>

}
package com.example.di

import com.example.data_remote.base.createWebService
import com.example.data_remote.base.getOkHttpClient
import com.example.data_remote.services.CollectionsService
import org.koin.dsl.module

val serviceModule = module {

    fun getBaseUrl() = BuildConfig.BASE_URL

    single { getOkHttpClient() }

    single { createWebService<CollectionsService>(getBaseUrl(), get()) }

}
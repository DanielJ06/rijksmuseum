package com.example.rijksmuseum

import android.app.Application
import com.example.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    companion object {
        lateinit var instance: BaseApplication
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                dataSourceModule,
                domainModule,
                presentationModule,
                repositoryModule,
                serviceModule
            )
        }
    }

}
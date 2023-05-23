package com.example.veedeo2

import android.app.Application
import com.example.pexels.di.PexelsApiModule
import com.example.veedeo2.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VeedeoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@VeedeoApplication)
            modules(
                listOf(appModule, PexelsApiModule)
            )
        }
    }
}
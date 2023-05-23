package com.example.pexels.di

import com.example.pexels.retrofit.PexelsApiClient
import com.example.pexels.service.IPexelsApi
import com.example.pexels.service.IPexelsApiService
import com.example.pexels.service.PexelsApiService
import org.koin.core.module.Module
import org.koin.dsl.module


val PexelsApiModule: Module = module {

    single {
        PexelsApiClient().build()
            .create(IPexelsApi::class.java)
    }

    factory<IPexelsApiService> {
        PexelsApiService(
            pexelsApi = get()
        )
    }

}
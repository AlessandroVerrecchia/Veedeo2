package com.example.veedeo2.di

import com.example.veedeo2.popular.GetPopularVideosUseCase
import com.example.veedeo2.popular.IGetPopularVideosUseCase
import com.example.veedeo2.popular.PopularVideosViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {

    factory<IGetPopularVideosUseCase> {
        GetPopularVideosUseCase(
            pexelsApiService = get()
        )
    }
    viewModel {
        PopularVideosViewModel(
            getPopularVideosUseCase = get()
        )
    }

}
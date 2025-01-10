package com.ag.projects.sebha.presentation.di.viewModel

import com.ag.projects.sebha.presentation.ui.screen.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel {
        HomeScreenViewModel(
            get(),
            get(),
            get(),
            get()
        )
    }

}
package com.ag.projects.sebha.presentation.di

import androidx.room.Room
import com.ag.projects.sebha.data.local.AzkarDatabase
import com.ag.projects.sebha.data.respository.AzkarRepositoryImpl
import com.ag.projects.sebha.domain.respository.AzkarRepository
import com.ag.projects.sebha.domain.usecase.get.GetAzkarUseCase
import com.ag.projects.sebha.domain.usecase.increment.IncrementAzkarCountUseCase
import com.ag.projects.sebha.domain.usecase.insert.InsertAzkarUseCase
import com.ag.projects.sebha.presentation.ui.screen.HomeScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val mainModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AzkarDatabase::class.java,
            "azkar.db"
        ).build()
    }

    single<AzkarRepository> {
        AzkarRepositoryImpl(get())
    }

    single {
        GetAzkarUseCase(get())
    }

    single {
        InsertAzkarUseCase(get())
    }

    single {
        IncrementAzkarCountUseCase(get())
    }

    viewModel {
        HomeScreenViewModel(
            get(),
            get(),
            get()
        )
    }

}
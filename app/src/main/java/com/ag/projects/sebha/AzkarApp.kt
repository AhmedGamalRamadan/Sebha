package com.ag.projects.sebha

import android.app.Application
import com.ag.projects.sebha.presentation.di.local.localDataModule
import com.ag.projects.sebha.presentation.di.viewModel.viewModelModule
import com.ag.projects.sebha.presentation.di.repository.repositoryModule
import com.ag.projects.sebha.presentation.di.usecase.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AzkarApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AzkarApp)
            modules(
                localDataModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}
package com.ag.projects.sebha.presentation.di.repository

import com.ag.projects.sebha.data.respository.AzkarRepositoryImpl
import com.ag.projects.sebha.domain.respository.AzkarRepository
import org.koin.dsl.module


val repositoryModule = module {

    single<AzkarRepository> {
        AzkarRepositoryImpl(get())
    }
}
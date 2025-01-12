package com.ag.projects.sebha.presentation.di.usecase

import com.ag.projects.sebha.domain.usecase.delete.DeleteAzkarUseCase
import com.ag.projects.sebha.domain.usecase.get.GetAzkarUseCase
import com.ag.projects.sebha.domain.usecase.increment.IncrementAzkarCountUseCase
import com.ag.projects.sebha.domain.usecase.insert.InsertAzkarUseCase
import com.ag.projects.sebha.domain.usecase.reset.ResetAzkarToZeroUseCase
import org.koin.dsl.module


val useCaseModule = module {

    single {
        GetAzkarUseCase(get())
    }

    single {
        InsertAzkarUseCase(get())
    }

    single {
        IncrementAzkarCountUseCase(get())
    }

    single {
        DeleteAzkarUseCase(get())
    }

    single {
        ResetAzkarToZeroUseCase(get())
    }

}
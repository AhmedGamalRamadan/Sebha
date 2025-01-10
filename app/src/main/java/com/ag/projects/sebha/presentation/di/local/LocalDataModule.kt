package com.ag.projects.sebha.presentation.di.local

import androidx.room.Room
import com.ag.projects.sebha.data.local.AzkarDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localDataModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AzkarDatabase::class.java,
            "azkar.db"
        ).build()
    }
}
package com.ag.projects.sebha

import android.app.Application
import com.ag.projects.sebha.presentation.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AzkarApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AzkarApp)
            modules(mainModule)
        }
    }
}
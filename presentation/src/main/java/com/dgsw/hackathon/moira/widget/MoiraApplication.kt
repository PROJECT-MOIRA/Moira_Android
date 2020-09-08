package com.dgsw.hackathon.moira.widget

import android.app.Application
import com.dgsw.hackathon.moira.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoiraApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MoiraApplication)

            val modules =
                listOf(netWorkModule, serviceModule, remoteModule, repositoryModule,
                    dataSourceModule, useCaseModule, viewModelModule)

            modules(modules)
        }
    }
}
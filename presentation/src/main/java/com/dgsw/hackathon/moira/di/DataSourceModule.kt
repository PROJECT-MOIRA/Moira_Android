package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.datasource.AuthDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { AuthDataSource(get(), Any()) }
}
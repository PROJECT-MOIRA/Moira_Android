package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.viewmodel.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainViewModel() }
}
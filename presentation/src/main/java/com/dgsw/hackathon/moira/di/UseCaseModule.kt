package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.usecase.LoginUseCase
import com.dgsw.hackathon.moira.usecase.RegisterUseCase
import org.koin.dsl.module

val useCaseModule = module {

    // Auth
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }
}
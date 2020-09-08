package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.repository.AuthRepository
import com.dgsw.hackathon.moira.repository.AuthRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}
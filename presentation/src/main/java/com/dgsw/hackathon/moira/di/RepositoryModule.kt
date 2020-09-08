package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<JobRepository> { JobRepositoryImpl(get()) }
    single<StudyRepository> { StudyRepositoryImpl(get()) }
}
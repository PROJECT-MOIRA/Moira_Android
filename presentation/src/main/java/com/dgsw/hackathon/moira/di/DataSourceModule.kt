package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.datasource.AuthDataSource
import com.dgsw.hackathon.moira.datasource.JobDataSource
import com.dgsw.hackathon.moira.datasource.StudyDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { AuthDataSource(get(), Any()) }
    single { JobDataSource(get(), Any()) }
    single { StudyDataSource(get(), Any()) }
}
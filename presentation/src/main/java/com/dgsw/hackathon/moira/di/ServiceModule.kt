package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.network.service.JobService
import com.dgsw.hackathon.moira.network.service.PortFolioService
import com.dgsw.hackathon.moira.network.service.StudyService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { (get() as Retrofit).create(JobService::class.java) }

    single { (get() as Retrofit).create(StudyService::class.java) }

    single { (get() as Retrofit).create(PortFolioService::class.java) }
}
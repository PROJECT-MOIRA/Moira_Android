package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.network.remote.AuthRemote
import com.dgsw.hackathon.moira.network.remote.JobRemote
import com.dgsw.hackathon.moira.network.remote.StudyRemote
import org.koin.dsl.module

val remoteModule = module {
    single { AuthRemote() }
    single { JobRemote(get()) }
    single { StudyRemote(get()) }
}
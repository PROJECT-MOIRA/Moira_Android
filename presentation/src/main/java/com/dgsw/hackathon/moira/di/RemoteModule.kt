package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.network.remote.AuthRemote
import org.koin.dsl.module

val remoteModule = module {
    single { AuthRemote() }
}
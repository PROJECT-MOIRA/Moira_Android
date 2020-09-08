package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.viewmodel.*
import org.koin.dsl.module

val viewModelModule = module {

    // activity
    single { LoginViewModel(get()) }
    single { JobOfferApplyViewModel() }
    single { StudyApplyViewModel() }

    // fragment
    single { HomeViewModel(get(), get()) }
    single { JobOfferViewModel(get()) }
    single { StudyViewModel(get()) }
    single { MenuViewModel() }
}
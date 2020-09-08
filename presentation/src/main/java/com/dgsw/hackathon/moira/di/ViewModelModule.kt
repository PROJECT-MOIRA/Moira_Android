package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.viewmodel.HomeViewModel
import com.dgsw.hackathon.moira.viewmodel.JobOfferViewModel
import com.dgsw.hackathon.moira.viewmodel.MenuViewModel
import com.dgsw.hackathon.moira.viewmodel.StudyViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { HomeViewModel() }
    single { JobOfferViewModel() }
    single { MenuViewModel() }
    single { StudyViewModel() }
}
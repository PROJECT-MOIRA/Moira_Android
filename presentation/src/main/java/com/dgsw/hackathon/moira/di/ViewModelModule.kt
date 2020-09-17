package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.viewmodel.*
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // activity
    viewModel { LoginViewModel(androidApplication(), get()) }
    viewModel { RegisterViewModel(get()) }

    viewModel { JobOfferApplyViewModel(androidApplication(), get()) }
    viewModel { JobOfferDetailViewModel() }

    viewModel { StudyApplyViewModel(androidApplication(), get()) }
    viewModel { StudyDetailViewModel() }

    viewModel { PortfolioViewModel(androidApplication(), get()) }
    viewModel { ProfileViewModel(androidApplication()) }

    // fragment
    viewModel { HomeViewModel(androidApplication(), get(), get()) }
    viewModel { JobOfferViewModel(get()) }
    viewModel { StudyViewModel(get()) }
    viewModel { MenuViewModel() }
}
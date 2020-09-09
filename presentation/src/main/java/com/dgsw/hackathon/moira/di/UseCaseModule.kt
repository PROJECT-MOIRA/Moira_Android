package com.dgsw.hackathon.moira.di

import com.dgsw.hackathon.moira.usecase.auth.LoginUseCase
import com.dgsw.hackathon.moira.usecase.auth.RegisterUseCase
import com.dgsw.hackathon.moira.usecase.job.DeleteJobOfferUseCase
import com.dgsw.hackathon.moira.usecase.job.GetAllJobOfferUseCase
import com.dgsw.hackathon.moira.usecase.job.PostJobOfferUseCase
import com.dgsw.hackathon.moira.usecase.job.PutJobOfferUseCase
import com.dgsw.hackathon.moira.usecase.portfolio.GetPortfolioUseCase
import com.dgsw.hackathon.moira.usecase.portfolio.PostPortfolioUseCase
import com.dgsw.hackathon.moira.usecase.study.DeleteStudyUseCase
import com.dgsw.hackathon.moira.usecase.study.GetAllStudyUseCase
import com.dgsw.hackathon.moira.usecase.study.PostStudyUseCase
import com.dgsw.hackathon.moira.usecase.study.PutStudyUseCase
import org.koin.dsl.module

val useCaseModule = module {

    // Auth
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }

    // Job
    single { GetAllJobOfferUseCase(get()) }
    single { PostJobOfferUseCase(get()) }
    single { DeleteJobOfferUseCase(get()) }
    single { PutJobOfferUseCase(get()) }

    // Study
    single { GetAllStudyUseCase(get()) }
    single { PostStudyUseCase(get()) }
    single { DeleteStudyUseCase(get()) }
    single { PutStudyUseCase(get()) }

    //Portfolio
    single { GetPortfolioUseCase(get()) }
    single { PostPortfolioUseCase(get()) }
}
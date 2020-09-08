package com.dgsw.hackathon.moira.usecase.job

import com.dgsw.hackathon.moira.base.BaseUseCase
import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.repository.JobRepository
import io.reactivex.Single

class GetAllJobOfferUseCase(
    private val jobRepository: JobRepository
) : BaseUseCase<Single<List<JobData>>>() {

    override fun buildUseCaseObservable(): Single<List<JobData>> =
        jobRepository.getAllJobOffer()
}
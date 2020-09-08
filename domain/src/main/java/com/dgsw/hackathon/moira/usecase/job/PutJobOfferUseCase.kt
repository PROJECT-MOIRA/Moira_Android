package com.dgsw.hackathon.moira.usecase.job

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.repository.JobRepository
import com.dgsw.hackathon.moira.request.job.PutJobOfferRequest
import io.reactivex.Completable

class PutJobOfferUseCase (
    private val jobRepository: JobRepository
) : ParamsUseCase<PutJobOfferUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
        jobRepository.putJobOffer(PutJobOfferRequest(
            params.field,
            params.description,
            params.people_num,
            0,
            params.writer,
            params.contact,
            params.job_idx
        ))

    data class Params(
        val field : String,
        val description: String,
        val people_num: Int,
        val writer: String,
        val contact: String,
        val job_idx: Int
    )
}
package com.dgsw.hackathon.moira.usecase.job

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.repository.JobRepository
import com.dgsw.hackathon.moira.request.job.DeleteJobOfferRequest
import io.reactivex.Completable

class DeleteJobOfferUseCase(
    private val jobRepository: JobRepository
) : ParamsUseCase<DeleteJobOfferUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
        jobRepository.deleteJobOffer(DeleteJobOfferRequest(
            params.writer,
            params.job_idx
        ))

    data class Params(
        val writer: String,
        val job_idx: Int
    )
}
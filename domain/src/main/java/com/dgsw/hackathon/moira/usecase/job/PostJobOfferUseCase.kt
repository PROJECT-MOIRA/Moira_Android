package com.dgsw.hackathon.moira.usecase.job

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.repository.JobRepository
import com.dgsw.hackathon.moira.request.job.PostJobOfferRequest
import io.reactivex.Completable

class PostJobOfferUseCase (
    private val jobRepository: JobRepository
) : ParamsUseCase<PostJobOfferUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
        jobRepository.postJobOffer(PostJobOfferRequest(
            params.title,
            params.field,
            params.description,
            params.people_num,
            0,
            params.writer,
            params.contact
        ))

    data class Params(
        val title: String,
        val field : String,
        val description: String,
        val people_num: Int,
        val writer: String,
        val contact: String
    )
}
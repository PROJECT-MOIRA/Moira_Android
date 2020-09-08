package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.request.job.DeleteJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PostJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PutJobOfferRequest
import io.reactivex.Completable
import io.reactivex.Single

interface JobRepository {

    fun getAllJobOffer() : Single<List<JobData>>

    fun postJobOffer(postJobOfferRequest: PostJobOfferRequest) : Completable

    fun deleteJobOffer(deleteJobOfferRequest: DeleteJobOfferRequest) : Completable

    fun putJobOffer(putJobOfferRequest: PutJobOfferRequest) : Completable
}
package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.datasource.JobDataSource
import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.request.job.DeleteJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PostJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PutJobOfferRequest
import io.reactivex.Completable
import io.reactivex.Single

class JobRepositoryImpl(
    private val jobDataSource: JobDataSource
) : JobRepository {

    override fun getAllJobOffer(): Single<List<JobData>> =
        jobDataSource.getAllJobOffer()

    override fun postJobOffer(postJobOfferRequest: PostJobOfferRequest): Completable =
        jobDataSource.postJobOffer(postJobOfferRequest).ignoreElement()

    override fun deleteJobOffer(deleteJobOfferRequest: DeleteJobOfferRequest): Completable =
        jobDataSource.deleteJobOffer(deleteJobOfferRequest).ignoreElement()

    override fun putJobOffer(putJobOfferRequest: PutJobOfferRequest): Completable =
        jobDataSource.putJobOffer(putJobOfferRequest).ignoreElement()
}
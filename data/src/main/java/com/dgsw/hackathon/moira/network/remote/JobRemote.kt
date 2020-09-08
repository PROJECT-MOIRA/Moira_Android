package com.dgsw.hackathon.moira.network.remote

import com.dgsw.hackathon.moira.base.BaseRemote
import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.network.service.JobService
import com.dgsw.hackathon.moira.request.job.DeleteJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PostJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PutJobOfferRequest
import io.reactivex.Single

class JobRemote(override val service: JobService): BaseRemote<JobService>() {

    fun getAllJobOffer() : Single<List<JobData>> =
        service.getAllJobOffer().map(getResponseData())

    fun postJobOffer(postJobOfferRequest: PostJobOfferRequest) : Single<String> =
        service.postJobOffer(postJobOfferRequest).map(getResponseMessage())

    fun deleteJobOffer(deleteJobOfferRequest: DeleteJobOfferRequest) : Single<String> =
        service.deleteJobOffer(deleteJobOfferRequest).map(getResponseMessage())

    fun putJobOffer(putJobOfferRequest: PutJobOfferRequest) : Single<String> =
        service.putJobOffer(putJobOfferRequest).map(getResponseMessage())
}
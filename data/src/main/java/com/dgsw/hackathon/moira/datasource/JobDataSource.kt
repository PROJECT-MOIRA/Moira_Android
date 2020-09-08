package com.dgsw.hackathon.moira.datasource

import com.dgsw.hackathon.moira.base.BaseDataSource
import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.network.remote.JobRemote
import com.dgsw.hackathon.moira.request.job.DeleteJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PostJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PutJobOfferRequest
import io.reactivex.Single

class JobDataSource(
    override val remote: JobRemote,
    override val cache: Any
) : BaseDataSource<JobRemote, Any>() {

    fun getAllJobOffer() : Single<List<JobData>> =
        remote.getAllJobOffer()

    fun postJobOffer(postJobOfferRequest: PostJobOfferRequest) : Single<String> =
        remote.postJobOffer(postJobOfferRequest)

    fun deleteJobOffer(deleteJobOfferRequest: DeleteJobOfferRequest) : Single<String> =
        remote.deleteJobOffer(deleteJobOfferRequest)

    fun putJobOffer(putJobOfferRequest: PutJobOfferRequest) : Single<String> =
        remote.putJobOffer(putJobOfferRequest)
}
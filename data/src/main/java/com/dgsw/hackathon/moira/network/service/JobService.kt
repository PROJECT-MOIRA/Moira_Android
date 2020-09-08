package com.dgsw.hackathon.moira.network.service

import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.network.response.Response
import com.dgsw.hackathon.moira.request.job.DeleteJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PostJobOfferRequest
import com.dgsw.hackathon.moira.request.job.PutJobOfferRequest
import io.reactivex.Single
import retrofit2.http.*

interface JobService {

    // 게시글 전체 조회
    @GET("job")
    fun getAllJobOffer() : Single<retrofit2.Response<Response<List<JobData>>>>

    // 게시글 작성
    @POST("job")
    fun postJobOffer(
        @Body postJobOfferRequest: PostJobOfferRequest
    ) : Single<retrofit2.Response<Response<Any>>>

    // 게시글 삭제
    @DELETE("job")
    fun deleteJobOffer(
        @Body deleteJobOfferRequest: DeleteJobOfferRequest
    ) : Single<retrofit2.Response<Response<Any>>>

    // 게시글 수정
    @PUT("job")
    fun putJobOffer(
        @Body putJobOfferRequest: PutJobOfferRequest
    ) : Single<retrofit2.Response<Response<Any>>>
}
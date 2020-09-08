package com.dgsw.hackathon.moira.network.service

import com.dgsw.hackathon.moira.model.StudyData
import com.dgsw.hackathon.moira.network.response.Response
import com.dgsw.hackathon.moira.request.study.DeleteStudyRequest
import com.dgsw.hackathon.moira.request.study.PostStudyRequest
import com.dgsw.hackathon.moira.request.study.PutStudyRequest
import io.reactivex.Single
import retrofit2.http.*

interface StudyService {

    // 게시글 전체 조회
    @GET("study")
    fun getAllStudy() : Single<retrofit2.Response<Response<List<StudyData>>>>

    // 게시글 작성
    @POST("study")
    fun postStudy(
        @Body postStudyRequest: PostStudyRequest
    ) : Single<retrofit2.Response<Response<Any>>>

    // 게시글 삭제
    @DELETE("study")
    fun deleteStudy(
        @Body deleteStudyRequest: DeleteStudyRequest
    ) : Single<retrofit2.Response<Response<Any>>>

    // 게시글 수정
    @PUT("study")
    fun putJStudy(
        @Body putStudyRequest: PutStudyRequest
    ) : Single<retrofit2.Response<Response<Any>>>
}
package com.dgsw.hackathon.moira.network.remote

import com.dgsw.hackathon.moira.base.BaseRemote
import com.dgsw.hackathon.moira.model.StudyData
import com.dgsw.hackathon.moira.network.service.StudyService
import com.dgsw.hackathon.moira.request.study.DeleteStudyRequest
import com.dgsw.hackathon.moira.request.study.PostStudyRequest
import com.dgsw.hackathon.moira.request.study.PutStudyRequest
import io.reactivex.Single

class StudyRemote(override val service: StudyService) : BaseRemote<StudyService>() {

    fun getAllStudy() : Single<List<StudyData>> =
        service.getAllStudy().map(getResponseData())

    fun postStudy(postStudyRequest: PostStudyRequest) : Single<String> =
        service.postStudy(postStudyRequest).map(getResponseMessage())

    fun deleteStudy(deleteStudyRequest: DeleteStudyRequest) : Single<String> =
        service.deleteStudy(deleteStudyRequest).map(getResponseMessage())

    fun putJStudy(putStudyRequest: PutStudyRequest) : Single<String> =
        service.putJStudy(putStudyRequest).map(getResponseMessage())
}
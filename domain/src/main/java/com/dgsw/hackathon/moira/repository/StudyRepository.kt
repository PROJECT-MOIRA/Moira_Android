package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.model.StudyData
import com.dgsw.hackathon.moira.request.study.DeleteStudyRequest
import com.dgsw.hackathon.moira.request.study.PostStudyRequest
import com.dgsw.hackathon.moira.request.study.PutStudyRequest
import io.reactivex.Completable
import io.reactivex.Single

interface StudyRepository {

    fun getAllStudy() : Single<List<StudyData>>

    fun postStudy(postStudyRequest: PostStudyRequest) : Completable

    fun deleteStudy(deleteStudyRequest: DeleteStudyRequest) : Completable

    fun putJStudy(putStudyRequest: PutStudyRequest) : Completable
}
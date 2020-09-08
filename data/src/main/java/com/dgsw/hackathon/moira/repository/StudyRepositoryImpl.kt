package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.datasource.StudyDataSource
import com.dgsw.hackathon.moira.model.StudyData
import com.dgsw.hackathon.moira.request.study.DeleteStudyRequest
import com.dgsw.hackathon.moira.request.study.PostStudyRequest
import com.dgsw.hackathon.moira.request.study.PutStudyRequest
import io.reactivex.Completable
import io.reactivex.Single

class StudyRepositoryImpl(
    private val studyDataSource: StudyDataSource
) : StudyRepository {

    override fun getAllStudy(): Single<List<StudyData>> =
        studyDataSource.getAllStudy()

    override fun postStudy(postStudyRequest: PostStudyRequest): Completable =
        studyDataSource.postStudy(postStudyRequest).ignoreElement()

    override fun deleteStudy(deleteStudyRequest: DeleteStudyRequest): Completable =
        studyDataSource.deleteStudy(deleteStudyRequest).ignoreElement()

    override fun putJStudy(putStudyRequest: PutStudyRequest): Completable =
        studyDataSource.putJStudy(putStudyRequest).ignoreElement()
}
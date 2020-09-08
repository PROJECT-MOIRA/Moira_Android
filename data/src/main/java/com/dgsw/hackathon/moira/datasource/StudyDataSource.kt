package com.dgsw.hackathon.moira.datasource

import com.dgsw.hackathon.moira.base.BaseDataSource
import com.dgsw.hackathon.moira.model.StudyData
import com.dgsw.hackathon.moira.network.remote.StudyRemote
import com.dgsw.hackathon.moira.request.study.DeleteStudyRequest
import com.dgsw.hackathon.moira.request.study.PostStudyRequest
import com.dgsw.hackathon.moira.request.study.PutStudyRequest
import io.reactivex.Single

class StudyDataSource(
    override val remote: StudyRemote,
    override val cache: Any
) : BaseDataSource<StudyRemote, Any>() {

    fun getAllStudy() : Single<List<StudyData>> =
        remote.getAllStudy()

    fun postStudy(postStudyRequest: PostStudyRequest) : Single<String> =
        remote.postStudy(postStudyRequest)

    fun deleteStudy(deleteStudyRequest: DeleteStudyRequest) : Single<String> =
        remote.deleteStudy(deleteStudyRequest)

    fun putJStudy(putStudyRequest: PutStudyRequest) : Single<String> =
        remote.putJStudy(putStudyRequest)
}
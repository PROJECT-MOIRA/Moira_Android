package com.dgsw.hackathon.moira.usecase.study

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.repository.StudyRepository
import com.dgsw.hackathon.moira.request.study.PostStudyRequest
import io.reactivex.Completable

class PostStudyUseCase(
    private val studyRepository: StudyRepository
) : ParamsUseCase<PostStudyUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
        studyRepository.postStudy(PostStudyRequest(
            params.title,
            params.subject,
            params.schedule_description,
            params.people_num,
            0,
            params.writer,
            params.contact
        ))

    data class Params(
        val title: String,
        val subject : String,
        val schedule_description: String,
        val people_num: Int,
        val writer: String,
        val contact: String
    )
}
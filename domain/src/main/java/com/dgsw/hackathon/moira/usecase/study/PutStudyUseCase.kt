package com.dgsw.hackathon.moira.usecase.study

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.repository.StudyRepository
import com.dgsw.hackathon.moira.request.study.PutStudyRequest
import io.reactivex.Completable

class PutStudyUseCase(
    private val studyRepository: StudyRepository
) : ParamsUseCase<PutStudyUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
        studyRepository.putJStudy(PutStudyRequest(
            params.subject,
            params.schedule_description,
            params.people_num,
            0,
            params.writer,
            params.contact,
            params.study_idx
        ))

    data class Params(
        val subject : String,
        val schedule_description: String,
        val people_num: Int,
        val writer: String,
        val contact: String,
        val study_idx: Int
    )
}
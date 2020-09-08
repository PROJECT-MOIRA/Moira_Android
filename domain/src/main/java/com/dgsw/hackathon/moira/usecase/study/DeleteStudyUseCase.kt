package com.dgsw.hackathon.moira.usecase.study

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.repository.StudyRepository
import com.dgsw.hackathon.moira.request.study.DeleteStudyRequest
import io.reactivex.Completable

class DeleteStudyUseCase(
    private val studyRepository: StudyRepository
) : ParamsUseCase<DeleteStudyUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
        studyRepository.deleteStudy(DeleteStudyRequest(
            params.writer,
            params.study_idx
        ))

    data class Params(
        val writer: String,
        val study_idx: Int
    )
}
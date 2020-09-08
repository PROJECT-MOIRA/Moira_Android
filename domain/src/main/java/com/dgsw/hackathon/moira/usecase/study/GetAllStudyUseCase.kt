package com.dgsw.hackathon.moira.usecase.study

import com.dgsw.hackathon.moira.base.BaseUseCase
import com.dgsw.hackathon.moira.model.StudyData
import com.dgsw.hackathon.moira.repository.StudyRepository
import io.reactivex.Single

class GetAllStudyUseCase(
    private val studyRepository: StudyRepository
): BaseUseCase<Single<List<StudyData>>>() {

    override fun buildUseCaseObservable(): Single<List<StudyData>> =
        studyRepository.getAllStudy()
}
package com.dgsw.hackathon.moira.viewmodel

import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.model.StudyData
import com.dgsw.hackathon.moira.usecase.study.GetAllStudyUseCase
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import com.dgsw.hackathon.moira.widget.recyclerview.adapter.StudyAdapter
import io.reactivex.observers.DisposableSingleObserver

class StudyViewModel(
    private val getAllStudyUseCase: GetAllStudyUseCase
) : BaseViewModel() {

    val studyAdapter = StudyAdapter()
    val studyList = ArrayList<StudyData>()

    val applyEvent = SingleLiveEvent<Unit>()

    init {
        getAllStudy()

        studyAdapter.setList(studyList)
    }

    private fun getAllStudy() {
        addDisposable(
            getAllStudyUseCase.buildUseCaseObservable(),
            object : DisposableSingleObserver<List<StudyData>>() {
                override fun onSuccess(t: List<StudyData>) {
                    studyList.addAll(t)
                    studyAdapter.notifyDataSetChanged()
                }
                override fun onError(e: Throwable) { }
            })
    }

    fun applyClick() {
        applyEvent.call()
    }
}
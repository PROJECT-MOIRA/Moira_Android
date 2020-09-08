package com.dgsw.hackathon.moira.viewmodel

import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.model.StudyData
import com.dgsw.hackathon.moira.usecase.job.GetAllJobOfferUseCase
import com.dgsw.hackathon.moira.usecase.study.GetAllStudyUseCase
import com.dgsw.hackathon.moira.widget.recyclerview.adapter.JobHomeAdapter
import com.dgsw.hackathon.moira.widget.recyclerview.adapter.StudyHomeAdapter
import io.reactivex.observers.DisposableSingleObserver

class HomeViewModel(
    private val getAllJobOfferUseCase: GetAllJobOfferUseCase,
    private val getAllStudyUseCase: GetAllStudyUseCase
) : BaseViewModel() {

    val jobAdapter = JobHomeAdapter()
    val jobList = ArrayList<JobData>()

    val studyAdapter = StudyHomeAdapter()
    val studyList = ArrayList<StudyData>()

    init {
        getAllJobOffer()
        getAllStudy()

        jobAdapter.setList(jobList)
        studyAdapter.setList(studyList)
    }

    private fun getAllJobOffer() {
        addDisposable(
            getAllJobOfferUseCase.buildUseCaseObservable(),
            object : DisposableSingleObserver<List<JobData>>() {
                override fun onSuccess(t: List<JobData>) {
                    jobList.addAll(t)
                    jobAdapter.notifyDataSetChanged()
                }
                override fun onError(e: Throwable) { }
            })
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
}
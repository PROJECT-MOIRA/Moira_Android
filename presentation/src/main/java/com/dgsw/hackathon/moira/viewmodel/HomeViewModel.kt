package com.dgsw.hackathon.moira.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.model.StudyData
import com.dgsw.hackathon.moira.usecase.job.GetAllJobOfferUseCase
import com.dgsw.hackathon.moira.usecase.study.GetAllStudyUseCase
import com.dgsw.hackathon.moira.util.SharedPreferenceManager
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import com.dgsw.hackathon.moira.widget.recyclerview.adapter.JobOfferAdapter
import com.dgsw.hackathon.moira.widget.recyclerview.adapter.StudyAdapter
import io.reactivex.observers.DisposableSingleObserver

class HomeViewModel(
    private val application: Application,
    private val getAllJobOfferUseCase: GetAllJobOfferUseCase,
    private val getAllStudyUseCase: GetAllStudyUseCase
) : BaseViewModel() {

    val id = MutableLiveData<String>()

    val jobAdapter = JobOfferAdapter()
    val jobList = ArrayList<JobData>()

    val studyAdapter = StudyAdapter()
    val studyList = ArrayList<StudyData>()

    val jobMoreEvent = SingleLiveEvent<Unit>()
    val studyMoreEvent = SingleLiveEvent<Unit>()

    init {
        getAllJobOffer()
        getAllStudy()

        id.value = SharedPreferenceManager.getId(application)

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

    fun jobMoreClick() {
        jobMoreEvent.call()
    }

    fun studyMoreClick() {
        studyMoreEvent.call()
    }
}
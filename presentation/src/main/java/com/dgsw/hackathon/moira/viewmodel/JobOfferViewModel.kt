package com.dgsw.hackathon.moira.viewmodel

import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.usecase.job.GetAllJobOfferUseCase
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import com.dgsw.hackathon.moira.widget.recyclerview.adapter.JobOfferAdapter
import io.reactivex.observers.DisposableSingleObserver

class JobOfferViewModel(
    private val getAllJobOfferUseCase: GetAllJobOfferUseCase
) : BaseViewModel() {

    val jobAdapter = JobOfferAdapter()
    val jobList = ArrayList<JobData>()

    val applyEvent = SingleLiveEvent<Unit>()

    init {
        getAllJobOffer()

        jobAdapter.setList(jobList)
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

    fun applyClick() {
        applyEvent.call()
    }
}
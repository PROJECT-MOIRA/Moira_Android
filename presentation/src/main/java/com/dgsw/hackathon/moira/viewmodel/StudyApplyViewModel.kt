package com.dgsw.hackathon.moira.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.usecase.study.PostStudyUseCase
import com.dgsw.hackathon.moira.util.SharedPreferenceManager
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import io.reactivex.observers.DisposableCompletableObserver

class StudyApplyViewModel(
    private val application: Application,
    private val postStudyUseCase: PostStudyUseCase
) : BaseViewModel() {

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val peopleNumber = MutableLiveData<String>()
    val contact = MutableLiveData<String>()
    val writer = MutableLiveData<String>()
    val field = MutableLiveData<String>()

    val backEvent = SingleLiveEvent<Unit>()
    val sendEvent = SingleLiveEvent<Unit>()

    val successEvent = SingleLiveEvent<Unit>()
    val errorEvent = MutableLiveData<String>()

    init {
        writer.value = SharedPreferenceManager.getId(application)
    }

    fun postStudy() {
        addDisposable(postStudyUseCase.buildUseCaseObservable(
            PostStudyUseCase.Params(
            title.value!!,
            field.value!!,
            description.value!!,
            peopleNumber.value!!.toInt(),
            writer.value!!,
            contact.value!!
        )), object : DisposableCompletableObserver() {
            override fun onComplete() {
                successEvent.call()
            }
            override fun onError(e: Throwable) {
                errorEvent.value = e.message
            }
        })
    }

    fun backClick() {
        backEvent.call()
    }

    fun sendClick() {
        sendEvent.call()
    }
}
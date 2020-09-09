package com.dgsw.hackathon.moira.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.usecase.job.PostJobOfferUseCase
import com.dgsw.hackathon.moira.util.SharedPreferenceManager
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import io.reactivex.observers.DisposableCompletableObserver

class JobOfferApplyViewModel(
    private val application: Application,
    private val postJobOfferUseCase: PostJobOfferUseCase
) : BaseViewModel() {

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val peopleNumber = MutableLiveData<String>()
    val contact = MutableLiveData<String>()
    val writer = MutableLiveData<String>()
    val field = MutableLiveData<String>()

    val backEvent = SingleLiveEvent<Unit>()
    val sendEvent = SingleLiveEvent<Unit>()

    val isMobile = MutableLiveData(false)
    val isWeb = MutableLiveData(false)
    val isServer = MutableLiveData(false)
    val isWindow = MutableLiveData(false)

    val successEvent = SingleLiveEvent<Unit>()
    val errorEvent = MutableLiveData<String>()

    init {
        writer.value = SharedPreferenceManager.getId(application)
    }

    fun postJobOffer() {
        addDisposable(postJobOfferUseCase.buildUseCaseObservable(PostJobOfferUseCase.Params(
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

    fun onCheckedMobile() {
        this.isMobile.value = true
        this.isWeb.value = false
        this.isServer.value = false
        this.isWindow.value = false
    }

    fun onCheckedWeb() {
        this.isMobile.value = false
        this.isWeb.value = true
        this.isServer.value = false
        this.isWindow.value = false
    }

    fun onCheckedServer() {
        this.isMobile.value = false
        this.isWeb.value = false
        this.isServer.value = true
        this.isWindow.value = false
    }

    fun onCheckedWindow() {
        this.isMobile.value = false
        this.isWeb.value = false
        this.isServer.value = false
        this.isWindow.value = true
    }

    fun backClick() {
        backEvent.call()
    }

    fun sendClick() {
        sendEvent.call()
    }
}
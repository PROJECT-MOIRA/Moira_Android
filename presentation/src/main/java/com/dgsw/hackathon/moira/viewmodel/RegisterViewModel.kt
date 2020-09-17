package com.dgsw.hackathon.moira.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.usecase.auth.RegisterUseCase
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import io.reactivex.observers.DisposableCompletableObserver

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val grade = MutableLiveData<String>()
    val contact = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    val registerEvent = SingleLiveEvent<Unit>()
    val successEvent = SingleLiveEvent<Unit>()
    val emptyEvent = SingleLiveEvent<Unit>()

    fun setRegister() {
        val isEmpty = id.value.isNullOrBlank() || pw.value.isNullOrBlank() || name.value.isNullOrBlank() ||
                grade.value.isNullOrBlank() || contact.value.isNullOrBlank() || email.value.isNullOrBlank()

        if (isEmpty) {
            emptyEvent.call()
            return
        }

        register()
    }

    private fun register() {
        addDisposable(registerUseCase.buildUseCaseObservable(RegisterUseCase.Params(
            id.value!!,
            pw.value!!,
            name.value!!,
            grade.value!!,
            contact.value!!,
            email.value!!
        )), object : DisposableCompletableObserver() {
            override fun onComplete() {
                successEvent.call()
            }
            override fun onError(e: Throwable) {

            }
        })
    }

    fun registerClick() {
        registerEvent.call()
    }
}
package com.dgsw.hackathon.moira.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.model.LoginData
import com.dgsw.hackathon.moira.usecase.auth.LoginUseCase
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import io.reactivex.observers.DisposableSingleObserver

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    val loginEvent = SingleLiveEvent<Unit>()

    val successEvent = MutableLiveData<String>()
    val errorEvent = MutableLiveData<String>()

    fun login() {
        addDisposable(
            loginUseCase.buildUseCaseObservable(LoginUseCase.Params(id.value!!, pw.value!!)),
            object : DisposableSingleObserver<LoginData>() {
                override fun onSuccess(t: LoginData) {
                    successEvent.value = t.token
                }
                override fun onError(e: Throwable) {
                    errorEvent.value = e.message
                }
            })
    }

    fun loginClick() {
        loginEvent.call()
    }
}
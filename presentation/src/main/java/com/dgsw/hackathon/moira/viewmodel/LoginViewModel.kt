package com.dgsw.hackathon.moira.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.usecase.LoginUseCase
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import io.reactivex.observers.DisposableCompletableObserver

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    val loginEvent = SingleLiveEvent<Unit>()
    val successEvent = SingleLiveEvent<Unit>()

    fun login() {
        addDisposable(
            loginUseCase.buildUseCaseObservable(LoginUseCase.Params(id.value!!, pw.value!!)),
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    successEvent.call()
                    Log.d("test", "success")
                }
                override fun onError(e: Throwable) {
                    Log.d("test", e.message.toString())
                }
            })
    }

    fun loginClick() {
        loginEvent.call()
    }
}
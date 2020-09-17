package com.dgsw.hackathon.moira.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.model.LoginData
import com.dgsw.hackathon.moira.usecase.auth.LoginUseCase
import com.dgsw.hackathon.moira.util.SharedPreferenceManager
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import io.reactivex.observers.DisposableSingleObserver

class LoginViewModel(
    private val application: Application,
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    val loginEvent = SingleLiveEvent<Unit>()
    val registerEvent = SingleLiveEvent<Unit>()

    val successEvent = SingleLiveEvent<Unit>()
    val errorEvent = MutableLiveData<String>()
    val emptyEvent = SingleLiveEvent<Unit>()

    fun setLogin() {
        val isEmpty = id.value.isNullOrBlank() || pw.value.isNullOrBlank()

        if (isEmpty) {
            emptyEvent.call()
            return
        }

        login()
    }

    private fun login() {
        addDisposable(
            loginUseCase.buildUseCaseObservable(LoginUseCase.Params(id.value!!, pw.value!!)),
            object : DisposableSingleObserver<LoginData>() {
                override fun onSuccess(t: LoginData) {
                    successEvent.call()
                    setInfo(t)
                }
                override fun onError(e: Throwable) {
                    errorEvent.value = e.message
                }
            })
    }

    fun setInfo(data: LoginData) {
        SharedPreferenceManager.setLoginData(application, data)
    }

    fun loginClick() {
        loginEvent.call()
    }

    fun registerClick() {
        registerEvent.call()
    }
}
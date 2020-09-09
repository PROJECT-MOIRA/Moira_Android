package com.dgsw.hackathon.moira.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.model.PortfolioData
import com.dgsw.hackathon.moira.usecase.portfolio.GetPortfolioUseCase
import com.dgsw.hackathon.moira.util.SharedPreferenceManager
import com.dgsw.hackathon.moira.widget.SingleLiveEvent
import io.reactivex.observers.DisposableSingleObserver

class PortfolioViewModel(
    private val application: Application,
    private val getPortfolioUseCase: GetPortfolioUseCase
) : BaseViewModel() {

    val github = MutableLiveData<String>()
    val blog = MutableLiveData<String>()
    val rocket = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val writer = MutableLiveData<String>()

    val backEvent = SingleLiveEvent<Unit>()
    val errorEvent = MutableLiveData<String>()

    init {
        writer.value = SharedPreferenceManager.getId(application)

        getPortfolio()
    }

    private fun getPortfolio() {
        addDisposable(getPortfolioUseCase.buildUseCaseObservable(GetPortfolioUseCase.Params(writer.value!!)),
        object : DisposableSingleObserver<List<PortfolioData>>() {
            override fun onSuccess(t: List<PortfolioData>) {
                setPortfolio(t[0])
            }
            override fun onError(e: Throwable) {
                errorEvent.value = e.message
            }
        })
    }

    private fun setPortfolio(data: PortfolioData) {
        github.value = data.github
        blog.value = data.blog
        rocket.value = data.rocketpunch
        description.value = data.description
    }

    fun backClick() {
        backEvent.call()
    }
}

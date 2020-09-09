package com.dgsw.hackathon.moira.viewmodel

import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.widget.SingleLiveEvent

class MenuViewModel : BaseViewModel() {

    val portfolioEvent = SingleLiveEvent<Unit>()
    val profileEvent = SingleLiveEvent<Unit>()

    fun portfolioClick() {
        portfolioEvent.call()
    }

    fun profileClick() {
        profileEvent.call()
    }
}
package com.dgsw.hackathon.moira.viewmodel

import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.widget.SingleLiveEvent

class JobOfferViewModel : BaseViewModel() {

    val applyEvent = SingleLiveEvent<Unit>()

    fun applyClick() {
        applyEvent.call()
    }
}
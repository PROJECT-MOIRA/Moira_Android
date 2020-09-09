package com.dgsw.hackathon.moira.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.util.JobOffer
import com.dgsw.hackathon.moira.widget.SingleLiveEvent

class JobOfferDetailViewModel : BaseViewModel() {

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val peopleNumber = MutableLiveData<String>()
    val contact = MutableLiveData<String>()
    val writer = MutableLiveData<String>()
    val field = MutableLiveData<String>()

    val backEvent = SingleLiveEvent<Unit>()

    init {
        setJobOffer()
    }

    private fun setJobOffer() {
        val data = JobOffer.getJob()

        title.value = data.title
        description.value = data.description
        peopleNumber.value = data.people_num.toString()
        contact.value = data.contact
        writer.value = data.writer
        field.value = data.field
    }

    fun backClick() {
        backEvent.call()
    }
}
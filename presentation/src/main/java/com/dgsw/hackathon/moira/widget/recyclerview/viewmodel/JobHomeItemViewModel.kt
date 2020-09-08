package com.dgsw.hackathon.moira.widget.recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dgsw.hackathon.moira.model.JobData

class JobHomeItemViewModel : ViewModel() {

    val title = MutableLiveData<String>()
    val field = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun bind(job : JobData) {
        title.value = job.title
        field.value = job.field
        description.value = job.description
    }
}
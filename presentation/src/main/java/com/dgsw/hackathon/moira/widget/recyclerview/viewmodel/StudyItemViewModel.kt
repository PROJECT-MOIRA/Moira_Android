package com.dgsw.hackathon.moira.widget.recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dgsw.hackathon.moira.model.StudyData

class StudyItemViewModel : ViewModel() {

    val title = MutableLiveData<String>()
    val field = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun bind(study : StudyData) {
        title.value = study.title
        field.value = study.subject
        description.value = study.schedule_description
    }
}
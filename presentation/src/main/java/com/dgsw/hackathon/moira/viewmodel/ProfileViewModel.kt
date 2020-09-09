package com.dgsw.hackathon.moira.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dgsw.hackathon.moira.base.BaseViewModel
import com.dgsw.hackathon.moira.util.SharedPreferenceManager

class ProfileViewModel(
    private val application: Application
) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val contact = MutableLiveData<String>()
    val grade = MutableLiveData<String>()

    init {
        setProfile()
    }

    private fun setProfile() {
        with(SharedPreferenceManager) {
            id.value = getId(application)
            email.value = getEmail(application)
            contact.value = getContact(application)
            grade.value = getGrade(application)
        }
    }
}
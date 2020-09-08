package com.dgsw.hackathon.moira.view.activtiy

import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityStudyApplyBinding
import com.dgsw.hackathon.moira.viewmodel.StudyApplyViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class StudyApplyActivity : BaseActivity<ActivityStudyApplyBinding, StudyApplyViewModel>() {

    override val viewModel: StudyApplyViewModel
        get() = getViewModel(StudyApplyViewModel::class)

    override fun observerVieModel() { }
}
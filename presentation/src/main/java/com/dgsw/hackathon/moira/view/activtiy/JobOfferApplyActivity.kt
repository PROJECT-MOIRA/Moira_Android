package com.dgsw.hackathon.moira.view.activtiy

import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityJobOfferApplyBinding
import com.dgsw.hackathon.moira.viewmodel.JobOfferApplyViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class JobOfferApplyActivity : BaseActivity<ActivityJobOfferApplyBinding, JobOfferApplyViewModel>() {

    override val viewModel: JobOfferApplyViewModel
        get() = getViewModel(JobOfferApplyViewModel::class)

    override fun observerVieModel() { }
}
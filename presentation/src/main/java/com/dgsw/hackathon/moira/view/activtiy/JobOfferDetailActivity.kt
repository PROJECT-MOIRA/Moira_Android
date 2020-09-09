package com.dgsw.hackathon.moira.view.activtiy

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityJobOfferDetailBinding
import com.dgsw.hackathon.moira.viewmodel.JobOfferDetailViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class JobOfferDetailActivity : BaseActivity<ActivityJobOfferDetailBinding, JobOfferDetailViewModel>() {

    override val viewModel: JobOfferDetailViewModel
        get() = getViewModel(JobOfferDetailViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            backEvent.observe(this@JobOfferDetailActivity, Observer {
                onBackPressed()
            })
        }
    }
}
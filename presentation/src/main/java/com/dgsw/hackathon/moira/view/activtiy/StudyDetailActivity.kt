package com.dgsw.hackathon.moira.view.activtiy

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityStudyDetailBinding
import com.dgsw.hackathon.moira.viewmodel.StudyDetailViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class StudyDetailActivity : BaseActivity<ActivityStudyDetailBinding, StudyDetailViewModel>() {

    override val viewModel: StudyDetailViewModel
        get() = getViewModel(StudyDetailViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            backEvent.observe(this@StudyDetailActivity, Observer {
                onBackPressed()
            })
        }
    }
}
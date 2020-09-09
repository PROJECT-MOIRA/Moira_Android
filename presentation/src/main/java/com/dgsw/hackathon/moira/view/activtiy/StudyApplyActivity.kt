package com.dgsw.hackathon.moira.view.activtiy

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityStudyApplyBinding
import com.dgsw.hackathon.moira.viewmodel.StudyApplyViewModel
import com.dgsw.hackathon.moira.widget.extension.shortToast
import com.dgsw.hackathon.moira.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class StudyApplyActivity : BaseActivity<ActivityStudyApplyBinding, StudyApplyViewModel>() {

    override val viewModel: StudyApplyViewModel
        get() = getViewModel(StudyApplyViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            sendEvent.observe(this@StudyApplyActivity, Observer {
                postStudy()
            })
            backEvent.observe(this@StudyApplyActivity, Observer {
                onBackPressed()
            })
            successEvent.observe(this@StudyApplyActivity, Observer {
                shortToast("작성 완료")
                startActivityWithFinish(NavigationActivity::class.java)
            })
            errorEvent.observe(this@StudyApplyActivity, Observer {
                shortToast(it)
            })
        }
    }
}
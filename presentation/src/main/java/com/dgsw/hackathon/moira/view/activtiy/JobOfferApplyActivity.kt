package com.dgsw.hackathon.moira.view.activtiy

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityJobOfferApplyBinding
import com.dgsw.hackathon.moira.viewmodel.JobOfferApplyViewModel
import com.dgsw.hackathon.moira.widget.extension.shortToast
import com.dgsw.hackathon.moira.widget.extension.startActivity
import com.dgsw.hackathon.moira.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class JobOfferApplyActivity : BaseActivity<ActivityJobOfferApplyBinding, JobOfferApplyViewModel>() {

    override val viewModel: JobOfferApplyViewModel
        get() = getViewModel(JobOfferApplyViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            sendEvent.observe(this@JobOfferApplyActivity, Observer {
                postJobOffer()
            })
            backEvent.observe(this@JobOfferApplyActivity, Observer {
                onBackPressed()
            })
            isMobile.observe(this@JobOfferApplyActivity, Observer {
                if (it) field.value = "Mobile"
            })
            isWeb.observe(this@JobOfferApplyActivity, Observer {
                if (it) field.value = "Web"
            })
            isServer.observe(this@JobOfferApplyActivity, Observer {
                if (it) field.value = "Server"
            })
            isWindow.observe(this@JobOfferApplyActivity, Observer {
                if (it) field.value = "Window"
            })
            successEvent.observe(this@JobOfferApplyActivity, Observer {
                shortToast("작성 완료")
                startActivityWithFinish(NavigationActivity::class.java)
            })
            errorEvent.observe(this@JobOfferApplyActivity, Observer {
                shortToast(it)
            })
        }
    }
}
package com.dgsw.hackathon.moira.view.activtiy

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityPortfolioBinding
import com.dgsw.hackathon.moira.viewmodel.PortfolioViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class PortfolioActivity : BaseActivity<ActivityPortfolioBinding, PortfolioViewModel>() {

    override val viewModel: PortfolioViewModel
        get() = getViewModel(PortfolioViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            backEvent.observe(this@PortfolioActivity, Observer {
                onBackPressed()
            })
        }
    }
}
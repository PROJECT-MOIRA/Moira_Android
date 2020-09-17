package com.dgsw.hackathon.moira.view.activtiy

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityProfileBinding
import com.dgsw.hackathon.moira.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ProfileActivity : BaseActivity<ActivityProfileBinding, ProfileViewModel>() {

    override val viewModel: ProfileViewModel
        get() = getViewModel(ProfileViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            backEvent.observe(this@ProfileActivity, Observer {
                onBackPressed()
            })
        }
    }
}
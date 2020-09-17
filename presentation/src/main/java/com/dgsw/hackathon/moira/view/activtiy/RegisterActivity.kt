package com.dgsw.hackathon.moira.view.activtiy

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.R
import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityRegisterBinding
import com.dgsw.hackathon.moira.viewmodel.RegisterViewModel
import com.dgsw.hackathon.moira.widget.extension.shortToast
import com.dgsw.hackathon.moira.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {

    override val viewModel: RegisterViewModel
        get() = getViewModel(RegisterViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            registerEvent.observe(this@RegisterActivity, Observer {
                setRegister()
            })
            emptyEvent.observe(this@RegisterActivity, Observer {
                shortToast("항목이 비었는지 확인해주세요")
            })
            successEvent.observe(this@RegisterActivity, Observer {
                startActivity(LoginActivity::class.java)
            })
        }
    }
}
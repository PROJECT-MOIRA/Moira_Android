package com.dgsw.hackathon.moira.view.activtiy

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityLoginBinding
import com.dgsw.hackathon.moira.viewmodel.LoginViewModel
import com.dgsw.hackathon.moira.widget.extension.shortToast
import com.dgsw.hackathon.moira.widget.extension.startActivity
import com.dgsw.hackathon.moira.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel
        get() = getViewModel(LoginViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            loginEvent.observe(this@LoginActivity, Observer {
                setLogin()
            })
            registerEvent.observe(this@LoginActivity, Observer {
                startActivity(RegisterActivity::class.java)
            })
            successEvent.observe(this@LoginActivity, Observer {
                startActivityWithFinish(NavigationActivity::class.java)
            })
            emptyEvent.observe(this@LoginActivity, Observer {
                shortToast("항목이 비었는지 확인해주세요")
            })
            errorEvent.observe(this@LoginActivity, Observer {
                shortToast(it)
            })
        }
    }
}
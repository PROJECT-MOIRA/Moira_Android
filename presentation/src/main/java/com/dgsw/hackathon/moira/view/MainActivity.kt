package com.dgsw.hackathon.moira.view

import com.dgsw.hackathon.moira.base.BaseActivity
import com.dgsw.hackathon.moira.databinding.ActivityMainBinding
import com.dgsw.hackathon.moira.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val mViewModel: MainViewModel
        get() = getViewModel(MainViewModel::class)

    override fun observerVieModel() { }
}
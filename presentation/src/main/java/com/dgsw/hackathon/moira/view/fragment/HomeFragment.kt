package com.dgsw.hackathon.moira.view.fragment

import com.dgsw.hackathon.moira.base.BaseFragment
import com.dgsw.hackathon.moira.databinding.FragmentHomeBinding
import com.dgsw.hackathon.moira.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val mViewModel: HomeViewModel
        get() = getViewModel(HomeViewModel::class)

    override fun observerVieModel() { }
}
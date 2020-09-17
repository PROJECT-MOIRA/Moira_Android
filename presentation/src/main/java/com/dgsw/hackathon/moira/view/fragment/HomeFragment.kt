package com.dgsw.hackathon.moira.view.fragment

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.base.BaseFragment
import com.dgsw.hackathon.moira.databinding.FragmentHomeBinding
import com.dgsw.hackathon.moira.view.activtiy.ProfileActivity
import com.dgsw.hackathon.moira.viewmodel.HomeViewModel
import com.dgsw.hackathon.moira.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel
        get() = getViewModel(HomeViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            profileEvent.observe(this@HomeFragment, Observer {
                startActivity(ProfileActivity::class.java)
            })
        }
    }
}
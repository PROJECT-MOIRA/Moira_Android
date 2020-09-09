package com.dgsw.hackathon.moira.view.fragment

import androidx.lifecycle.Observer
import com.dgsw.hackathon.moira.base.BaseFragment
import com.dgsw.hackathon.moira.databinding.FragmentMenuBinding
import com.dgsw.hackathon.moira.view.activtiy.PortfolioActivity
import com.dgsw.hackathon.moira.view.activtiy.ProfileActivity
import com.dgsw.hackathon.moira.viewmodel.MenuViewModel
import com.dgsw.hackathon.moira.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MenuFragment : BaseFragment<FragmentMenuBinding, MenuViewModel>() {

    override val viewModel: MenuViewModel
        get() = getViewModel(MenuViewModel::class)

    override fun observerVieModel() {
        with(viewModel) {
            portfolioEvent.observe(this@MenuFragment, Observer {
                startActivity(PortfolioActivity::class.java)
            })
            profileEvent.observe(this@MenuFragment, Observer {
                startActivity(ProfileActivity::class.java)
            })
        }
    }
}
package com.dgsw.hackathon.moira.view.fragment

import com.dgsw.hackathon.moira.base.BaseFragment
import com.dgsw.hackathon.moira.databinding.FragmentMenuBinding
import com.dgsw.hackathon.moira.viewmodel.MenuViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MenuFragment : BaseFragment<FragmentMenuBinding, MenuViewModel>() {

    override val viewModel: MenuViewModel
        get() = getViewModel(MenuViewModel::class)

    override fun observerVieModel() { }
}
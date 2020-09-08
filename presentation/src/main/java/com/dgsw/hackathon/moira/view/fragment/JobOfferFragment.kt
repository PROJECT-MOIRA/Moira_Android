package com.dgsw.hackathon.moira.view.fragment

import com.dgsw.hackathon.moira.base.BaseFragment
import com.dgsw.hackathon.moira.databinding.FragmentJobOfferBinding
import com.dgsw.hackathon.moira.viewmodel.JobOfferViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class JobOfferFragment : BaseFragment<FragmentJobOfferBinding, JobOfferViewModel>() {

    override val mViewModel: JobOfferViewModel
        get() = getViewModel(JobOfferViewModel::class)

    override fun observerVieModel() {}
}
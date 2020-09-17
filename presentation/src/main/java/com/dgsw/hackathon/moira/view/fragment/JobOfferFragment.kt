package com.dgsw.hackathon.moira.view.fragment

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.dgsw.hackathon.moira.base.BaseFragment
import com.dgsw.hackathon.moira.databinding.FragmentJobOfferBinding
import com.dgsw.hackathon.moira.util.JobOffer
import com.dgsw.hackathon.moira.view.activtiy.JobOfferApplyActivity
import com.dgsw.hackathon.moira.view.activtiy.JobOfferDetailActivity
import com.dgsw.hackathon.moira.viewmodel.JobOfferViewModel
import com.dgsw.hackathon.moira.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class JobOfferFragment : BaseFragment<FragmentJobOfferBinding, JobOfferViewModel>() {

    override val viewModel: JobOfferViewModel
        get() = getViewModel(JobOfferViewModel::class)

    override fun observerVieModel() {
        binding.recyclerView.layoutManager = GridLayoutManager(context, 3)

        with(viewModel) {
            applyEvent.observe(this@JobOfferFragment, Observer {
                startActivity(JobOfferApplyActivity::class.java)
            })
            jobAdapter.shortClick.observe(this@JobOfferFragment, Observer {
                JobOffer.setJob(jobList[it])
                startActivity(JobOfferDetailActivity::class.java)
            })
        }
    }
}
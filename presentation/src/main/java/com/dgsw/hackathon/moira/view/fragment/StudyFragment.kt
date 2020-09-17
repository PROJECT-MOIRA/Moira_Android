package com.dgsw.hackathon.moira.view.fragment

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.dgsw.hackathon.moira.base.BaseFragment
import com.dgsw.hackathon.moira.databinding.FragmentStudyBinding
import com.dgsw.hackathon.moira.util.Study
import com.dgsw.hackathon.moira.view.activtiy.JobOfferDetailActivity
import com.dgsw.hackathon.moira.view.activtiy.StudyApplyActivity
import com.dgsw.hackathon.moira.view.activtiy.StudyDetailActivity
import com.dgsw.hackathon.moira.viewmodel.StudyDetailViewModel
import com.dgsw.hackathon.moira.viewmodel.StudyViewModel
import com.dgsw.hackathon.moira.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class StudyFragment : BaseFragment<FragmentStudyBinding, StudyViewModel>() {

    override val viewModel: StudyViewModel
        get() = getViewModel(StudyViewModel::class)

    override fun observerVieModel() {
        binding.recyclerView.layoutManager = GridLayoutManager(context, 3)

        with(viewModel) {
            applyEvent.observe(this@StudyFragment, Observer {
                startActivity(StudyApplyActivity::class.java)
            })
            studyAdapter.shortClick.observe(this@StudyFragment, Observer {
                Study.setStudy(studyList[it])
                startActivity(StudyDetailActivity::class.java)
            })
        }
    }
}
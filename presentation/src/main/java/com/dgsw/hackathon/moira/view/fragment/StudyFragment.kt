package com.dgsw.hackathon.moira.view.fragment

import com.dgsw.hackathon.moira.base.BaseFragment
import com.dgsw.hackathon.moira.databinding.FragmentStudyBinding
import com.dgsw.hackathon.moira.viewmodel.StudyViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class StudyFragment : BaseFragment<FragmentStudyBinding, StudyViewModel>() {

    override val mViewModel: StudyViewModel
        get() = getViewModel(StudyViewModel::class)

    override fun observerVieModel() { }
}
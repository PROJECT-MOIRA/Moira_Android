package com.dgsw.hackathon.moira.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dgsw.hackathon.moira.R
import com.dgsw.hackathon.moira.databinding.ItemJobHomeBinding
import com.dgsw.hackathon.moira.model.JobData
import com.dgsw.hackathon.moira.widget.recyclerview.viewmodel.JobHomeItemViewModel

class JobHomeAdapter : RecyclerView.Adapter<JobHomeAdapter.ViewHolder>(){

    private lateinit var jobList : ArrayList<JobData>

    fun setList(list : ArrayList<JobData>) {
        if(::jobList.isInitialized) return
        jobList = list
    }

    class ViewHolder(private val binding : ItemJobHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = JobHomeItemViewModel()

        fun bind(job: JobData) {
            viewModel.bind(job)
            binding.viewModel = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_job_home,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return if(::jobList.isInitialized) jobList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        with(holder) {
            bind(jobList[position])
        }
    }
}
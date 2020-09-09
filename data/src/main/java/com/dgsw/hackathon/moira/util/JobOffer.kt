package com.dgsw.hackathon.moira.util

import com.dgsw.hackathon.moira.model.JobData

object JobOffer {

    private lateinit var jobData: JobData

    fun setJob(jobData: JobData) {
        this.jobData = jobData
    }

    fun getJob() : JobData {
        return jobData
    }
}
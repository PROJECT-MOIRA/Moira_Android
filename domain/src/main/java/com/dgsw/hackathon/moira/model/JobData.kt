package com.dgsw.hackathon.moira.model

data class JobData(
    val contact: String,
    val description: String,
    val field: String,
    val is_deadline: Int,
    val job_idx: Int,
    val people_num: Int,
    val title: String,
    val writer: String
)
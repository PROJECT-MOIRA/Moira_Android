package com.dgsw.hackathon.moira.request.job

data class DeleteJobOfferRequest (
    val writer: String,
    val job_idx: Int
)
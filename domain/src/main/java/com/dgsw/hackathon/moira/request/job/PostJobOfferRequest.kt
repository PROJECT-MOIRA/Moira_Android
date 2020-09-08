package com.dgsw.hackathon.moira.request.job

data class PostJobOfferRequest (
    val title: String,
    val field : String,
    val description: String,
    val people_num: Int,
    val is_deadline: Int,
    val writer: String,
    val contact: String
)
package com.dgsw.hackathon.moira.request.study

data class PostStudyRequest (
    val title: String,
    val subject : String,
    val schedule_description: String,
    val people_num: Int,
    val is_deadline: Int,
    val writer: String,
    val contact: String
)
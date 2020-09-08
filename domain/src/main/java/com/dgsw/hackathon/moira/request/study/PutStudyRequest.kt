package com.dgsw.hackathon.moira.request.study

class PutStudyRequest (
    val subject : String,
    val schedule_description: String,
    val people_num: Int,
    val is_deadline: Int,
    val writer: String,
    val contact: String,
    val study_idx: Int
)
package com.dgsw.hackathon.moira.model

data class StudyData(
    val contact: String,
    val is_deadline: Int,
    val people_num: Int,
    val schedule_description: String,
    val study_idx: Int,
    val subject: String,
    val title: String,
    val writer: String
)
package com.dgsw.hackathon.moira.util

import com.dgsw.hackathon.moira.model.StudyData

object Study {

    private lateinit var studyData: StudyData

    fun setStudy(studyData: StudyData) {
        this.studyData = studyData
    }

    fun getStudy() : StudyData {
        return studyData
    }
}
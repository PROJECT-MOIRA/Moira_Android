package com.dgsw.hackathon.moira.widget.extension

import android.view.View
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.setStatusMode() {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}
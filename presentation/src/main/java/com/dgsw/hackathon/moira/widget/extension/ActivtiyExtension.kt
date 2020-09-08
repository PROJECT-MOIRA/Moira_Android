package com.dgsw.hackathon.moira.widget.extension

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.setStatusMode() {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}

fun AppCompatActivity.shortToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.shortToast(message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.startActivity(activity: Class<*>) {
    startActivity(Intent(applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}

fun AppCompatActivity.startActivityWithFinish(activity: Class<*>) {
    startActivity(Intent(applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    this.finish()
}
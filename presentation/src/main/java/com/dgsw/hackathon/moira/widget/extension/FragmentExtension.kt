package com.dgsw.hackathon.moira.widget.extension

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.util.ArrayList

fun Fragment.shortToast(message: String?) {
    Toast.makeText(context!!.applicationContext, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.shortToast(message: Int) {
    Toast.makeText(context!!.applicationContext, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.startActivity(activity: Class<*>) {
    startActivity(Intent(context!!.applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}

fun Fragment.startActivityWithFinish(activity: Class<*>) {
    startActivity(Intent(context!!.applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    requireActivity().finish()
}
package com.dgsw.hackathon.moira.util

import android.content.Context
import android.content.SharedPreferences
import com.dgsw.hackathon.moira.model.LoginData

object SharedPreferenceManager {
    private const val PREF_TOKEN = "token"
    private const val PREF_ID = "id"
    private const val PREF_EMAIL = "email"
    private const val PREF_CONTACT = "contact"
    private const val PREF_GRADE = "grade"

    fun setLoginData(context: Context, loginData: LoginData) {
        with(getDefaultSharedPreferences(context).edit()) {
            putString(PREF_TOKEN, loginData.token).apply()
            putString(PREF_ID, loginData.id).apply()
            putString(PREF_EMAIL, loginData.email).apply()
            putString(PREF_CONTACT, loginData.contact).apply()
            putString(PREF_GRADE, loginData.grade).apply()
        }
    }

    fun getToken(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(PREF_TOKEN, null)
    }

    fun getId(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(PREF_ID, null)
    }

    fun getEmail(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(PREF_EMAIL, null)
    }

    fun getContact(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(PREF_CONTACT, null)
    }

    fun getGrade(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(PREF_GRADE, null)
    }

    private fun getDefaultSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
            getDefaultSharedPreferencesMode())
    }

    private fun getDefaultSharedPreferencesName(context: Context): String {
        return context.packageName.toString() + "_preferences"
    }

    private fun getDefaultSharedPreferencesMode(): Int {
        return Context.MODE_PRIVATE
    }
}
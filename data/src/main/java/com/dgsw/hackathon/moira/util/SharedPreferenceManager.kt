package com.dgsw.hackathon.moira.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceManager {
    private const val PREF_TOKEN = "token"
    private const val PREF_ID = "id"

    fun setToken(context: Context, token: String) {
        getDefaultSharedPreferences(context).edit().putString(PREF_TOKEN, token).apply()
    }

    fun getToken(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(PREF_TOKEN, null)
    }

    fun setId(context: Context, id: String) {
        getDefaultSharedPreferences(context).edit().putString(PREF_ID, id).apply()
    }

    fun getId(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(PREF_ID, null)
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
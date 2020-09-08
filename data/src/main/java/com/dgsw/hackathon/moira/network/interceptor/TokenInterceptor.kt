package com.dgsw.hackathon.moira.network.interceptor

import android.app.Application
import com.dgsw.hackathon.moira.util.SharedPreferenceManager
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(
    private val application: Application
) : Interceptor {

    lateinit var token: String

    override fun intercept(chain: Interceptor.Chain): Response {
        setToken()

        val request= chain.request().newBuilder().header("token", token).build()
        return chain.proceed(request)
    }

    private fun setToken() {
        token = SharedPreferenceManager.getToken(application)!!
    }
}
package com.dgsw.hackathon.moira.network.remote

import com.dgsw.hackathon.moira.base.RetrofitRemote
import com.dgsw.hackathon.moira.network.response.data.LoginData
import com.dgsw.hackathon.moira.network.service.AuthService
import com.dgsw.hackathon.moira.request.LoginRequest
import com.dgsw.hackathon.moira.request.RegisterRequest
import io.reactivex.Single

class AuthRemote : RetrofitRemote<AuthService>() {

    override val service: AuthService
        get() = createService(AuthService::class.java)

    fun login(loginRequest: LoginRequest): Single<LoginData> =
        service.login(loginRequest).map(getResponseData())

    fun register(registerRequest: RegisterRequest): Single<String> =
        service.register(registerRequest).map(getResponseMessage())
}
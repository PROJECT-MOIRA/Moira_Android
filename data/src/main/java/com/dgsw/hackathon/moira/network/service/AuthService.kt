package com.dgsw.hackathon.moira.network.service

import com.dgsw.hackathon.moira.network.response.Response
import com.dgsw.hackathon.moira.model.LoginData
import com.dgsw.hackathon.moira.request.auth.LoginRequest
import com.dgsw.hackathon.moira.request.auth.RegisterRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    // 로그인
    @POST("auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ): Single<retrofit2.Response<Response<LoginData>>>

    // 회원가입
    @POST("auth/register")
    fun register(
        @Body registerRequest: RegisterRequest
    ): Single<retrofit2.Response<Response<Any>>>
}
package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.model.LoginData
import com.dgsw.hackathon.moira.request.auth.LoginRequest
import com.dgsw.hackathon.moira.request.auth.RegisterRequest
import io.reactivex.Completable
import io.reactivex.Single

interface AuthRepository {

    fun login(loginRequest: LoginRequest): Single<LoginData>

    fun register(registerRequest: RegisterRequest): Completable
}
package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.request.LoginRequest
import com.dgsw.hackathon.moira.request.RegisterRequest
import io.reactivex.Completable

interface AuthRepository {

    fun login(loginRequest: LoginRequest): Completable

    fun register(registerRequest: RegisterRequest): Completable
}
package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.datasource.AuthDataSource
import com.dgsw.hackathon.moira.request.LoginRequest
import com.dgsw.hackathon.moira.request.RegisterRequest
import io.reactivex.Completable

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource
) : AuthRepository {

    override fun login(loginRequest: LoginRequest): Completable =
        authDataSource.login(loginRequest).ignoreElement()

    override fun register(registerRequest: RegisterRequest): Completable =
        authDataSource.register(registerRequest).ignoreElement()
}
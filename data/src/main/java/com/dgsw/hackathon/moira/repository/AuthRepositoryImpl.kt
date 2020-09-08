package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.datasource.AuthDataSource
import com.dgsw.hackathon.moira.model.LoginData
import com.dgsw.hackathon.moira.request.auth.LoginRequest
import com.dgsw.hackathon.moira.request.auth.RegisterRequest
import com.dgsw.hackathon.moira.util.SharedPreferenceManager
import io.reactivex.Completable
import io.reactivex.Single

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource
) : AuthRepository {

    override fun login(loginRequest: LoginRequest): Single<LoginData> =
        authDataSource.login(loginRequest)

    override fun register(registerRequest: RegisterRequest): Completable =
        authDataSource.register(registerRequest).ignoreElement()
}
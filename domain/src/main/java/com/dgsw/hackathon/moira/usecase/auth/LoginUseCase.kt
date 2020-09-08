package com.dgsw.hackathon.moira.usecase.auth

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.model.LoginData
import com.dgsw.hackathon.moira.repository.AuthRepository
import com.dgsw.hackathon.moira.request.auth.LoginRequest
import io.reactivex.Single

class LoginUseCase(
    private val authRepository: AuthRepository
) : ParamsUseCase<LoginUseCase.Params, Single<LoginData>>() {

    override fun buildUseCaseObservable(params: Params): Single<LoginData> =
        authRepository.login(
            LoginRequest(
                params.id,
                params.pw
            )
        )

    data class Params(
        val id: String,
        val pw: String
    )
}
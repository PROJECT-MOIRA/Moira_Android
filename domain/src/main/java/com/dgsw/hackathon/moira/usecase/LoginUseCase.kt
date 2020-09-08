package com.dgsw.hackathon.moira.usecase

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.repository.AuthRepository
import com.dgsw.hackathon.moira.request.LoginRequest
import io.reactivex.Completable

class LoginUseCase(
    private val authRepository: AuthRepository
) : ParamsUseCase<LoginUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
        authRepository.login(LoginRequest(params.id, params.pw))

    data class Params(
        val id: String,
        val pw: String
    )
}
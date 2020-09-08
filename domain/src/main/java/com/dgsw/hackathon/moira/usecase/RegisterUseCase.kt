package com.dgsw.hackathon.moira.usecase

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.repository.AuthRepository
import com.dgsw.hackathon.moira.request.RegisterRequest
import io.reactivex.Completable

class RegisterUseCase(
    private val authRepository: AuthRepository
): ParamsUseCase<RegisterUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
        authRepository.register(RegisterRequest(
            params.id,
            params.pw,
            params.name,
            params.grade,
            params.contact,
            params.email
        ))

    data class Params(
        val id : String,
        val pw: String,
        val name: String,
        val grade: String,
        val contact: String,
        val email: String
    )
}
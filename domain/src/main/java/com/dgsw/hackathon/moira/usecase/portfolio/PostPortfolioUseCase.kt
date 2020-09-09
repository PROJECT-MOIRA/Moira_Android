package com.dgsw.hackathon.moira.usecase.portfolio

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.repository.PortfolioRepository
import com.dgsw.hackathon.moira.request.portfolio.PostPortfolioRequest
import io.reactivex.Completable

class PostPortfolioUseCase(
    private val portfolioRepository: PortfolioRepository
) : ParamsUseCase<PostPortfolioUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
        portfolioRepository.postPortfolio(PostPortfolioRequest(
            params.writer,
            params.description,
            params.github,
            params.blog,
            params.rocketpunch
        ))

    data class Params(
        val writer: String,
        val description: String,
        val github: String,
        val blog: String,
        val rocketpunch: String
    )
}
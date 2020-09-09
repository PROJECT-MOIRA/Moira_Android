package com.dgsw.hackathon.moira.usecase.portfolio

import com.dgsw.hackathon.moira.base.ParamsUseCase
import com.dgsw.hackathon.moira.model.PortfolioData
import com.dgsw.hackathon.moira.repository.PortfolioRepository
import io.reactivex.Single

class GetPortfolioUseCase(
    private val portfolioRepository: PortfolioRepository
) : ParamsUseCase<GetPortfolioUseCase.Params, Single<List<PortfolioData>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<PortfolioData>> =
        portfolioRepository.getPortfolio(params.writer)

    data class Params(
        val writer: String
    )
}
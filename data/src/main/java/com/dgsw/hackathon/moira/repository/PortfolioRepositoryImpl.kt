package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.datasource.PortfolioDataSource
import com.dgsw.hackathon.moira.model.PortfolioData
import com.dgsw.hackathon.moira.request.portfolio.PostPortfolioRequest
import io.reactivex.Completable
import io.reactivex.Single

class PortfolioRepositoryImpl(
    private val portfolioDataSource: PortfolioDataSource
) : PortfolioRepository {

    override fun getPortfolio(writer: String): Single<List<PortfolioData>> =
        portfolioDataSource.getPortfolio(writer)

    override fun postPortfolio(postPortfolioRequest: PostPortfolioRequest): Completable =
        portfolioDataSource.postPortfolio(postPortfolioRequest).ignoreElement()
}
package com.dgsw.hackathon.moira.repository

import com.dgsw.hackathon.moira.model.PortfolioData
import com.dgsw.hackathon.moira.request.portfolio.PostPortfolioRequest
import io.reactivex.Completable
import io.reactivex.Single

interface PortfolioRepository {

    fun getPortfolio(writer: String): Single<List<PortfolioData>>

    fun postPortfolio(postPortfolioRequest: PostPortfolioRequest): Completable
}
package com.dgsw.hackathon.moira.network.remote

import com.dgsw.hackathon.moira.base.BaseRemote
import com.dgsw.hackathon.moira.model.PortfolioData
import com.dgsw.hackathon.moira.network.service.PortFolioService
import com.dgsw.hackathon.moira.request.portfolio.PostPortfolioRequest
import io.reactivex.Single

class PortfolioRemote(override val service: PortFolioService) : BaseRemote<PortFolioService>() {

    fun getPortfolio(writer: String): Single<List<PortfolioData>> =
        service.getPortfolio(writer).map(getResponseData())

    fun postPortfolio(postPortfolioRequest: PostPortfolioRequest): Single<String> =
        service.postPortfolio(postPortfolioRequest).map(getResponseMessage())
}
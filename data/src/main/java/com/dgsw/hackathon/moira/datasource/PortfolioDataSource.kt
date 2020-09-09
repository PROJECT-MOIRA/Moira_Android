package com.dgsw.hackathon.moira.datasource

import com.dgsw.hackathon.moira.base.BaseDataSource
import com.dgsw.hackathon.moira.model.PortfolioData
import com.dgsw.hackathon.moira.network.remote.PortfolioRemote
import com.dgsw.hackathon.moira.request.portfolio.PostPortfolioRequest
import io.reactivex.Single

class PortfolioDataSource(
    override val remote: PortfolioRemote,
    override val cache: Any
) : BaseDataSource<PortfolioRemote, Any>() {

    fun getPortfolio(writer: String): Single<List<PortfolioData>> =
        remote.getPortfolio(writer)

    fun postPortfolio(postPortfolioRequest: PostPortfolioRequest): Single<String> =
        remote.postPortfolio(postPortfolioRequest)
}
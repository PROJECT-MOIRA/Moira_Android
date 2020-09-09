package com.dgsw.hackathon.moira.network.service

import com.dgsw.hackathon.moira.model.PortfolioData
import com.dgsw.hackathon.moira.network.response.Response
import com.dgsw.hackathon.moira.request.portfolio.PostPortfolioRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PortFolioService {

    @GET("portfolio/{writer}")
    fun getPortfolio(
        @Path("writer") writer: String
    ): Single<retrofit2.Response<Response<List<PortfolioData>>>>

    @POST("portfolio")
    fun postPortfolio(
        @Body postPortfolioRequest: PostPortfolioRequest
    ): Single<retrofit2.Response<Response<Any>>>
}
package com.dgsw.hackathon.moira.request.portfolio

data class PostPortfolioRequest(
    val writer: String,
    val description: String,
    val github: String,
    val blog: String,
    val rocketpunch: String
)
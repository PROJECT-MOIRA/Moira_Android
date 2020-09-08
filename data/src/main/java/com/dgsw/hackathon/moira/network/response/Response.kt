package com.dgsw.hackathon.moira.network.response

class Response<T>(val status: Int,
                  val message: String,
                  val data: T)
package com.dgsw.hackathon.moira.base

abstract class BaseUseCase<out T> {
    abstract fun buildUseCaseObservable(): T
}
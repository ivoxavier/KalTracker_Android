package com.ivoxavier.kaltracker.service.repository.listener

interface APIListener<T> {
    fun onSuccess(result: T)
    fun onFailure(message: String)
}
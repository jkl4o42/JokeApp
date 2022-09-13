package com.jkl4o4.jokeapp

interface JokeService {
    fun getJoke(callback: ServiceCallback)
}

interface ServiceCallback {
    fun returnSuccess(data: String)
    fun returnError(type: ErrorType)
}

enum class ErrorType {
    NO_CONNECTION,
    OTHER
}

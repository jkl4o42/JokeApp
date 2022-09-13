package com.jkl4o4.jokeapp

import java.io.BufferedInputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException

class BaseJokeService : JokeService {

    override fun getJoke(callback: ServiceCallback) {
        Thread {
            var connection: HttpURLConnection? = null
            try {
                val url = URL(JOKE_URL)
                connection = url.openConnection() as HttpURLConnection
                InputStreamReader(BufferedInputStream(connection.inputStream)).use {
                    val line: String = it.readText()
                    callback.returnSuccess(line)
                }
            } catch (e: Exception) {
                if (e is UnknownHostException)
                    callback.returnError(ErrorType.NO_CONNECTION)
                else
                    callback.returnError(ErrorType.OTHER)
            } finally {
                connection?.disconnect()
            }
        }.start()
    }

    companion object {
        const val JOKE_URL = "https://official-joke-api.appspot.com/random_joke/"
    }
}
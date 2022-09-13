package com.jkl4o4.jokeapp

class ViewModel(private val model: Model) {

    private var callback: TextCallback? = null

    fun init(textCallback: TextCallback) {
        this.callback = textCallback
        model.init(object : ResultCallback {
            override fun provideSuccess(data: Joke) = textCallback.provideText(data.getJokeUi())
            override fun provideError(data: JokeFailure) = textCallback.provideText(data.getMessage())
        })
    }

    fun getJoke() {
        model.getJoke()
    }

    fun clear() {
        callback = null
        model.clear()
    }
}

interface TextCallback {
    fun provideText(text: String)
}
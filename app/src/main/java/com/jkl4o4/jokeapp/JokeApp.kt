package com.jkl4o4.jokeapp

import android.app.Application

class JokeApp : Application() {

    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(BaseModel(BaseJokeService(), BaseResourceManager(this)))
    }
}
package com.jalpa.jet2travel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ArticleViewModel(application: Application) : AndroidViewModel(application) {

    private val response: MutableLiveData<ArticleResponse> by lazy {
        MutableLiveData<ArticleResponse>().also {
            loadArticles()
        }
    }


    private fun loadArticles() {

    }



}

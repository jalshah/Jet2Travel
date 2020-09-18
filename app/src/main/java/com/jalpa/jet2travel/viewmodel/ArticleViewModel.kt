package com.jalpa.jet2travel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArticleViewModel : ViewModel() {

    private val apiRepository: ApiRepository = ApiRepository()


    fun loadArticles(page: Int) : MutableLiveData<ArticleResponse>{
        apiRepository.fetchArticles(page)
         return  apiRepository.getArticles()
    }

}



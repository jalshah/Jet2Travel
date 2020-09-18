package com.jalpa.jet2travel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArticleViewModel : ViewModel() {

    private  var  response: MutableLiveData<ArticleResponse> = MutableLiveData()

    private val apiRepository: ApiRepository = ApiRepository()


    fun loadArticles(page: Int) : MutableLiveData<ArticleResponse>{
        apiRepository.fetchArticles(page)
         return  apiRepository.getArticles()
    }

}



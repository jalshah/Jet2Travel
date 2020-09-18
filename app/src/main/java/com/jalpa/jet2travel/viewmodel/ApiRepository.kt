package com.jalpa.jet2travel.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jalpa.jet2travel.network.ArticleApi
import com.jalpa.jet2travel.network.RetrofitServiceManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {
    var articleResponse: MutableLiveData<ArticleResponse> = MutableLiveData()
    private var articleApi: ArticleApi
    val limit = 10
    val apiextension="blogs"

    constructor(){
        articleApi = RetrofitServiceManager.createService(ArticleApi::class.java)
    }

    fun fetchArticles(number: Int) {
        articleApi.getArticles(apiextension,number, limit).enqueue(object : Callback<List<Article>> {

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                articleResponse.value = ArticleResponse(t)
            }


            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                if (response.isSuccessful)
                    articleResponse.value =  ArticleResponse(response.body())
            }

        })
    }

    fun getArticles(): MutableLiveData<ArticleResponse> {
        return articleResponse
    }
}
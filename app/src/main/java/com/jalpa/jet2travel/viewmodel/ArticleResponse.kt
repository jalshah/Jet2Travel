package com.jalpa.jet2travel.viewmodel

class ArticleResponse {
    var articles: List<Article>? = listOf()
    var error: Throwable? = null

    constructor(articles: List<Article>?){
        this.articles = articles

    }

    constructor(articles :Throwable){
        this.error = articles
    }

}
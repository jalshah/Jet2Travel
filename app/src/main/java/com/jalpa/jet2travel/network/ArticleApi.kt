package com.jalpa.jet2travel.network

import com.jalpa.jet2travel.viewmodel.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Call the Url to fetch the images.
 */
interface ArticleApi {
    @GET("{fullUrl}")
    fun getArticles(
        @Path( value = "fullUrl",  encoded = true) string: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Call<List<Article>>
}
package com.jalpa.jet2travel.viewmodel

import com.google.gson.annotations.SerializedName

class Media {
    @SerializedName("id")
    lateinit var id: String

    @SerializedName("blogId")
    lateinit var blogId: String

    @SerializedName("createdAt")
    lateinit var createdAt:String

    @SerializedName("image")
    lateinit var imageUrl : String

    @SerializedName("title")
    lateinit var title: String

    @SerializedName("url")
    lateinit var url: String
}
package com.jalpa.jet2travel.viewmodel

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("id")
    lateinit var id: String

    @SerializedName("blogId")
    lateinit var blogId: String

    @SerializedName("createdAt")
    lateinit var createdAt: String

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("avatar")
    lateinit var avtar: String

    @SerializedName("lastname")
    lateinit var lastName: String

    @SerializedName("city")
    lateinit var city: String

    @SerializedName("designation")
    lateinit var designation: String

    @SerializedName("about")
    lateinit var about: String

}

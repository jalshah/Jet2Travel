package com.jalpa.jet2travel.viewmodel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class User  : Parcelable {
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

    constructor(parcel: Parcel)  {
        id = parcel.readString().toString()
        blogId = parcel.readString().toString()
        createdAt = parcel.readString().toString()
        name = parcel.readString().toString()
        avtar = parcel.readString().toString()
        lastName = parcel.readString().toString()
        city = parcel.readString().toString()
        designation = parcel.readString().toString()
        about = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(blogId)
        parcel.writeString(createdAt)
        parcel.writeString(name)
        parcel.writeString(avtar)
        parcel.writeString(lastName)
        parcel.writeString(city)
        parcel.writeString(designation)
        parcel.writeString(about)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}

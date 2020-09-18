package com.jalpa.jet2travel.viewmodel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Media() : Parcelable {
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

    constructor(parcel: Parcel) : this() {
        id = parcel.readString().toString()
        blogId = parcel.readString().toString()
        createdAt = parcel.readString().toString()
        imageUrl = parcel.readString().toString()
        title = parcel.readString().toString()
        url = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(blogId)
        parcel.writeString(createdAt)
        parcel.writeString(imageUrl)
        parcel.writeString(title)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Media> {
        override fun createFromParcel(parcel: Parcel): Media {
            return Media(parcel)
        }

        override fun newArray(size: Int): Array<Media?> {
            return arrayOfNulls(size)
        }
    }
}
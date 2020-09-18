package com.jalpa.jet2travel.viewmodel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


class Article : Parcelable {

    @SerializedName("id")
    lateinit var id:String

    @SerializedName("createdAt")
    lateinit var date: String

    @SerializedName("content")
    lateinit var content:String

    @SerializedName("comments")
    var commentCount: Long = 0

    @SerializedName("likes")
    var likes : Long =0

    @SerializedName("media")
    lateinit var media :List<Media>

    @SerializedName("user")
    lateinit var user: List<User>

    constructor(parcel: Parcel)  {
        id = parcel.readString().toString()
        date = parcel.readString().toString()
        content = parcel.readString().toString()
        commentCount = parcel.readLong()
        likes = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(date)
        parcel.writeString(content)
        parcel.writeLong(commentCount)
        parcel.writeLong(likes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }


}

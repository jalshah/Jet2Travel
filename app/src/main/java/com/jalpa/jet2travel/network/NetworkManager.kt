package com.jalpa.jet2travel.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo

object NetworkManager {
    fun isNetworkAvailable(context: Context): Boolean {
        var isConnected = false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo: NetworkInfo? = null
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.activeNetworkInfo
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            isConnected = true
        }
        return isConnected
    }
}
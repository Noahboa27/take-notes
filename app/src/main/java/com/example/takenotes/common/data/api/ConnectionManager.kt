package com.example.takenotes.common.data.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ConnectionManager @Inject constructor(@ApplicationContext private val context: Context) {

    fun isConnected(): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = manager.getNetworkCapabilities(manager.activeNetwork)
        val connection = capabilities?.let {
            it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
            it.hasTransport(NetworkCapabilities.TRANSPORT_VPN)
        }
        return connection ?: false
    }
}
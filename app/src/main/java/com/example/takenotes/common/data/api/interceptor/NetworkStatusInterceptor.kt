package com.example.takenotes.common.data.api.interceptor

import com.example.takenotes.common.data.api.ConnectionManager
import com.example.takenotes.common.domain.model.Exceptions.NetworkUnavailableException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkStatusInterceptor @Inject constructor(private val connectionManager: ConnectionManager) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return if (connectionManager.isConnected()) {
            chain.proceed(chain.request())
        } else {
            throw NetworkUnavailableException()
        }
    }
}
package com.example.takenotes.common.data.api.interceptor

import com.example.takenotes.common.utils.Logger
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class LoggingInterceptor @Inject constructor() : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Logger.info(null, message)
    }
}
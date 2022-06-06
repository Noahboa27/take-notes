package com.example.takenotes.common.utils

import android.util.Log
import java.lang.Exception

object Logger {

    fun verbose(tag: String? = null, message: String) = Log.v(tag, message)

    fun info(tag: String? = null, message: String) = Log.i(tag, message)

    fun debug(tag: String? = null, message: String) = Log.d(tag, message)

    fun error(
        tag: String? = null,
        message: String,
        exception: Exception? = null
    ) = Log.e(tag, message, exception)

}
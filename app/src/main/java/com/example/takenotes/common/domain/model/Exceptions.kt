package com.example.takenotes.common.domain.model

import java.io.IOException

class Exceptions {

    class NetworkUnavailableException(message: String = "No network available :(") : IOException(message)

    class NetworkException(message: String) : Exception(message)

}
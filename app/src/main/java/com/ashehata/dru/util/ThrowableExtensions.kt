package com.ashehata.dru.util

import com.ashehata.dru.R
import com.ashehata.dru.common.models.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    return when (this) {
        is IOException -> {
            NetworkError(
                message = this.message,
                messageRes = R.string.no_internet
            )
        }

        is HttpException -> {
            val messageRes = when (this.code()) {
                400 -> R.string.not_found
                500 -> R.string.server_error
                else -> R.string.unknown
                // add more error codes here as you want
            }
            NetworkError(
                message = this.message,
                messageRes = messageRes,
            )
        }

        else -> {
            NetworkError(
                message = this.localizedMessage,
                messageRes = R.string.unknown
            )
        }
    }

}
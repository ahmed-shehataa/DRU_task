package com.ashehata.dru.common.models

import androidx.annotation.StringRes

data class NetworkError(
    @StringRes val messageRes: Int,
    val message: String?,
)

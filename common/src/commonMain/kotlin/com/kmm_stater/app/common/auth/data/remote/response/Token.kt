package com.kmm_stater.app.common.auth.data.remote.response

import kotlinx.serialization.SerialName


data class Token(
    @SerialName("access_token") val accessToken: String,
    @SerialName("refresh_token") val refreshToken: String,
)
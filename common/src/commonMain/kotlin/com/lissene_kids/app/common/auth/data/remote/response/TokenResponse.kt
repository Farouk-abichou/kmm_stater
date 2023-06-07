package com.lissene_kids.app.common.auth.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
) {
    fun toToken() = Token(
        accessToken = accessToken,
        refreshToken = refreshToken,
    )
}
package com.kmm_stater.app.common.auth.data.remote.response

import kotlinx.serialization.Serializable


@Serializable
data class LogInResponse(
    val data: LoginData,
)

@Serializable
data class LoginData(
    val tokens: TokenResponse,
)
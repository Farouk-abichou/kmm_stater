package com.lissene_kids.app.common.auth.domain.model

import kotlinx.serialization.SerialName


data class Token(
    @SerialName("access_token") val accessToken: String,
    @SerialName("refresh_token") val refreshToken: String,
)
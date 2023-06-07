package com.kmm_stater.app.common.core.network

import com.kmm_stater.app.common.auth.data.local.tokenSettings
import com.kmm_stater.app.common.auth.data.remote.response.TokenResponse
import com.kmm_stater.app.common.core.network.util.RefreshUrl
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

fun createAuthHttpClient(
    noAuthClient: HttpClient,
): HttpClient {
    return createNoAuthHttpClient().config {
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        tokenSettings.getString("accessToken",""),
                        tokenSettings.getString("refreshToken",""),
                    )
                }

                refreshTokens {
                    try {
                        val response: HttpResponse = noAuthClient.get(urlString = RefreshUrl) {
                            request {
                                bearerAuth(
                                    tokenSettings.getString("accessToken", ""),
                                )
                                setBody(
                                    hashMapOf(
                                        "refreshToken" to tokenSettings.getString("refreshToken", ""),
                                    )
                                )
                            }
                        }

                        val token = response.body<TokenResponse>()
                        tokenSettings.putString("accessToken", token.accessToken)
                        tokenSettings.putString("refreshToken", token.refreshToken)

                        BearerTokens(
                            accessToken = token.accessToken,
                            refreshToken = token.refreshToken
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                        tokenSettings.putString("accessToken", "")
                        tokenSettings.putString("refreshToken", "")
                        throw UnauthorizedException()
                    }
                }
            }
        }
    }
}
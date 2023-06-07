package com.lissene_kids.app.common.auth.data.remote

import com.lissene_kids.app.common.auth.data.local.tokenSettings
import com.lissene_kids.app.common.auth.data.remote.response.LogInResponse
import com.lissene_kids.app.common.auth.data.remote.response.SignupResponse
import com.lissene_kids.app.common.auth.domain.model.SignupInput
import com.lissene_kids.app.common.auth.domain.model.Token
import com.lissene_kids.app.common.core.network.util.LoginUrl
import com.lissene_kids.app.common.core.network.util.RefreshUrl
import com.lissene_kids.app.common.core.network.util.SignupUrl
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named


class AuthClient : KoinComponent {
    private val client: HttpClient by inject(named("NoAuth"))
    suspend fun login(
        email: String,
        password: String
    ): LogInResponse {
        val response: HttpResponse = client.post(urlString = LoginUrl) {
            setBody(
                hashMapOf(
                    "email" to email,
                    "password" to password,
                )
            )
        }

        val result = response.body<LogInResponse>()

        tokenSettings.putString("accessToken", result.data.tokens.accessToken)
        tokenSettings.putString("refreshToken", result.data.tokens.refreshToken)

        return result
    }

    suspend fun signup(signupInfo: SignupInput): SignupResponse {
        val postResponse: HttpResponse = client.post(urlString = SignupUrl) {
            setBody(
                hashMapOf(
                    "name" to signupInfo.firstName,
                    "lastname" to signupInfo.lastName,
                    "email" to signupInfo.email,
                    "phoneNumber" to signupInfo.phoneNumber,
                    "password" to signupInfo.password,
                )
            )
        }

        return Json.decodeFromString<SignupResponse>(postResponse.body<String>())
    }

    suspend fun refreshToken(): Token {
        val response = client.post(
            urlString = RefreshUrl,
        ) {
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

        val token = Json.decodeFromString<Token>(response.body())
        tokenSettings.putString("accessToken", token.accessToken)
        tokenSettings.putString("refreshToken", token.refreshToken)

        return token
    }

}
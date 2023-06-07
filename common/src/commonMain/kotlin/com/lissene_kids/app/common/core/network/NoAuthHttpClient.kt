package com.lissene_kids.app.common.core.network

import com.lissene_kids.app.common.auth.data.util.BaseUrl
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun createNoAuthHttpClient(): HttpClient {
    return createPlatformHttpClient().config {
        defaultRequest {
            url(BaseUrl)
            contentType(ContentType.Application.Json)
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }
}
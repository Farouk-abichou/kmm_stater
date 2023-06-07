package com.kmm_stater.app.common.core.network

import io.ktor.client.*
import io.ktor.client.engine.android.*

actual fun createPlatformHttpClient(): HttpClient {
    return HttpClient(Android)
}
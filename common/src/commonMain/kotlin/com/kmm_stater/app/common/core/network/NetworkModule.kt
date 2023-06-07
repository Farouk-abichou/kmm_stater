package com.kmm_stater.app.common.core.network

import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("NoAuth")) { createNoAuthHttpClient() }
    single(named("Auth")) { createAuthHttpClient(get(named("NoAuth"))) }
}
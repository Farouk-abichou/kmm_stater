package com.kmm_stater.app.common.core.di


import com.kmm_stater.app.common.auth.di.authModule
import com.kmm_stater.app.common.core.network.networkModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration) = run {
    startKoin {
        appDeclaration()
        modules(
            networkModule,

            authModule,

        )
    }
}


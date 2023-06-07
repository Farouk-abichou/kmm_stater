package com.lissene_kids.app.common.core.di


import com.lissene_kids.app.common.core.network.networkModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration) = run {
    startKoin {
        appDeclaration()
        modules(
            networkModule,

        )
    }
}


package com.kmm_stater.app.common.auth.di

import com.kmm_stater.app.common.auth.domain.repository.AuthRepository
import com.kmm_stater.app.common.auth.data.remote.AuthClient
import com.kmm_stater.app.common.auth.data.repository.AuthRepositoryImpl
import org.koin.dsl.module

val authModule = module {
    single { AuthClient() }
    single<AuthRepository> { AuthRepositoryImpl() }
}
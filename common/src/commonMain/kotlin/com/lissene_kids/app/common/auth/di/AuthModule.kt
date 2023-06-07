package com.lissene_kids.app.common.auth.di

import com.lissene_kids.app.common.auth.domain.repository.AuthRepository
import com.lissene_kids.app.common.auth.data.remote.AuthClient
import com.lissene_kids.app.common.auth.data.repository.AuthRepositoryImpl
import org.koin.dsl.module

val authModule = module {
    single { AuthClient() }
    single<AuthRepository> { AuthRepositoryImpl() }
}
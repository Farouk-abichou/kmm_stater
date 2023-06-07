package com.lissene_kids.app.android.auth.core.di

import com.lissene_kids.app.android.auth.login.AndroidLoginViewModel
import com.lissene_kids.app.android.home.AndroidSignupViewModel
import com.lissene_kids.app.common.auth.data.repository.AuthRepositoryImpl
import com.lissene_kids.app.common.auth.domain.repository.AuthRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<AuthRepository> { AuthRepositoryImpl() }
    viewModel { AndroidLoginViewModel() }
    viewModel { AndroidSignupViewModel() }

}
package com.lissene_kids.app.common.auth.presentation.login.state

data class LoginState(
    val isFailure: Boolean = false,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
)
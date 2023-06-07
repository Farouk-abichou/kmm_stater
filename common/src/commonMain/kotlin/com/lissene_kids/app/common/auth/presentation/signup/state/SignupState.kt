package com.lissene_kids.app.common.auth.presentation.signup.state

data class SignupState(
    val isFailure: Boolean = false,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
)
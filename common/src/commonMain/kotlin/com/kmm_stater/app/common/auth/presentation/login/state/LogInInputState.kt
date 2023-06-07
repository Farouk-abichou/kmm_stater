package com.kmm_stater.app.common.auth.presentation.login.state

data class LogInInputState(
    val isInputValid: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val email: String = "",
    val password: String = "",
)
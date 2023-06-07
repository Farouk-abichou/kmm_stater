package com.kmm_stater.app.common.auth.presentation.login.event

sealed class LoginEvent {
    data class Login(val email: String, val password: String) : LoginEvent()
    data class TypeEmail(val email: String) : LoginEvent()
    data class TypePassword(val password: String) : LoginEvent()
    object RememberUser : LoginEvent()
    object ShowPassword : LoginEvent()
    object HidePassword : LoginEvent()
}


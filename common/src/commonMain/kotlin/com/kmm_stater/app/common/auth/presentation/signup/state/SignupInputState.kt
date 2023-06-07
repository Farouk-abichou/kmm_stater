package com.kmm_stater.app.common.auth.presentation.signup.state


data class SignupInputState(

    val isInputValid: Boolean = false,
    val alreadyHaveAccount : Boolean = false,

    val firstName : String = "",
    val lastName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val password: String = "",
)